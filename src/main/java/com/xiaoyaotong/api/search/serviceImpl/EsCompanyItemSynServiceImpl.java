package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.config.Constants;
import com.xiaoyaotong.api.search.dao.EsCompanyItemDao;
import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsCompanyItemSynService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
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

            int count = companySkuService.getCompanyItemCount();
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

                    esCompanyItemDao.save(esItem);
                    currentMaxId = currentMaxId > esItem.getId()?currentMaxId : esItem.getId(); //得到最大的minimumId

                }
                beginIter=beginIter + 1;
            }
        }


    @Override
    public void synIncrementCompanyItem() {

    }
}
