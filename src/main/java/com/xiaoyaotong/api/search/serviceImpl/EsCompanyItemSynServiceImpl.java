package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.config.Constants;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.search.dao.EsCompanyItemDao;
import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsCompanyItemSynService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：billHe
 * @description：本类主要用于对商家自己的商品进行全量同步和增量同步
 * @date ：2019/12/21 8:39 PM
 */
@Service
public class EsCompanyItemSynServiceImpl implements EsCompanyItemSynService {
        private static Log log = LogFactory.getLog(EsSpuSynServiceImpl.class);

        @Autowired
        CompanySkuService companySkuService;

        @Autowired
        EsCompanyItemDao esCompanyItemDao;

        @Autowired
        private RedisTemplate<String, String> stringRedis;

        @Override
        public void synAllCompanyItem() {
            log.info("CompanyItem全量同步开始！");

            int count = companySkuService.getCompanyItemCount(0);
            int beginIter = 0;
            int pageSize = 1000;
            long currentMaxId = 0;

            //分页获取数据
            log.info("同步数量为："+ count);
            while(beginIter * pageSize < count){
                List<CompanySku> lists = companySkuService.getCompanySkuList(beginIter,pageSize);

                for(CompanySku item : lists){
                    EsCompanyItem esItem = new EsCompanyItem();
                    esItem.setCommonName(item.getCommonName());
                    esItem.setApprovalCode(item.getApprovalCode());
                    esItem.setSpec(item.getSpec());
                    esItem.setSpuCode(item.getSpuCode());
                    esItem.setFactoryName(item.getFactoryName());
                    esItem.setBarCode(item.getBarCode());
                    esItem.setId(item.getId());
                    esItem.setCompanyId(item.getCompanyId());
                    esItem.setCompanySkuCode(item.getCompanySkuCode());
                    esItem.setMatched(item.getMatched());

                    esCompanyItemDao.save(esItem);
                    currentMaxId = currentMaxId > esItem.getId()?currentMaxId : esItem.getId(); //得到最大的minimumId

                }
                beginIter=beginIter + 1;
            }
        }


    @Override
    public void synIncrementCompanyItem() {
        log.info("CompanyItem增量同步开始！");
        Date now = new Date();
        Date dd = new Date(now.getTime() - 300000);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beginTime = formatter.format(dd);


        int changePlatformCount = companySkuService.getIncrementCompanyItemCount(beginTime);
        int beginPage = 0;
        int pageSize = 1000;
        log.info("同步的数量为："+changePlatformCount);
        while(beginPage * pageSize < changePlatformCount){
            List<CompanySku> lists = companySkuService.getIncrementCompanyItemList(beginTime, beginPage,pageSize);
            for(CompanySku item : lists){
                EsCompanyItem esItem = new EsCompanyItem();
                esItem.setCommonName(item.getCommonName());
                esItem.setApprovalCode(item.getApprovalCode());
                esItem.setSpec(item.getSpec());
                esItem.setSpuCode(item.getSpuCode());
                esItem.setFactoryName(item.getFactoryName());
                esItem.setBarCode(item.getBarCode());
                esItem.setId(item.getId());
                esItem.setCompanyId(item.getCompanyId());
                esItem.setCompanySkuCode(item.getCompanySkuCode());
                esItem.setMatched(item.getMatched());
                esCompanyItemDao.save(esItem);
            }
            beginPage = beginPage + 1;
        }
    }
}
