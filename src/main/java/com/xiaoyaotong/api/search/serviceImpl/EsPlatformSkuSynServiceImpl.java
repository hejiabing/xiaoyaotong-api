package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.config.Constants;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.search.dao.EsPlatformSkuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsMedicineSpuService;
import com.xiaoyaotong.api.search.service.EsPlatformSkuSynService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/10 10:11 PM
 */
@Service
public class EsPlatformSkuSynServiceImpl implements EsPlatformSkuSynService {
    private static Log log = LogFactory.getLog(EsSpuSynServiceImpl.class);


    @Autowired
    PlatformSkuService platformSkuService;

    @Autowired
    EsPlatformSkuDao esPlatformSkuDao;

    @Autowired
    MedicineSPUService medicineSPUService;

    @Autowired
    private RedisTemplate<String, String> stringRedis;

    @Override
    public void synAllSku() {
        log.info("SKU全量同步开始！");

        stringRedis.boundValueOps(Constants.ES_ALL_SKU_SYNC).set(Constants.ES_SYNC_BEGIN);
        int count = platformSkuService.getAllPlatformSkuCount();
        int beginPage = 0;
        int pageSize = 1000;
        int currentMaxId = 0;
        stringRedis.boundValueOps(Constants.ES_ALL_SKU_SYNC).set(Constants.ES_SYNC_DOING);
        //分页获取数据
        log.info("同步数量为："+count);
        while(beginPage * pageSize < count){
            List<PlatformSku> lists = platformSkuService.getPlatformSkuList(beginPage,pageSize);
            //同步sku到ES
            for(PlatformSku sku : lists){
                MedicineSPU spu = medicineSPUService.getBySpuCode(sku.getSpuCode());

                EsPlatformSku esSku = new EsPlatformSku();
                esSku.setCommonName(spu.getCommonName());
                esSku.setApprovalCode(spu.getApprovalCode());
                esSku.setSpec(spu.getSpec());
                esSku.setSpuCode(sku.getSpuCode());
                esSku.setFactoryName(spu.getFactoryName());
                esSku.setShortName(spu.getShortName());
                esSku.setFormalName(spu.getFormalName());
                esSku.setBarCode(spu.getBarCode());
                esSku.setId(sku.getId());
                esSku.setCompanyId(sku.getCompanyId());
                esSku.setCompanyName(sku.getCompanyName());
                esSku.setSkuCode(sku.getSkuCode());
                esSku.setStatus(sku.getStatus());
                esPlatformSkuDao.save(esSku);
                currentMaxId = currentMaxId > spu.getId()?currentMaxId : spu.getId(); //得到最大的minimumId

            }
            beginPage = beginPage + 1;
        }
        stringRedis.boundValueOps(Constants.ES_ALL_SKU_SYNC).set(Constants.ES_SYNC_FINISHED);
        stringRedis.boundValueOps(Constants.ES_INCREMENT_SKU_SYNC_MAXID).set("" + currentMaxId);
        log.info("SKU全量同步结束！");
    }

    @Override
    public void synIncrementSku() {
        log.info("SKU增量同步开始");
        Date now = new Date();
        Date beginTime = new Date(now.getTime() - 420000);

        int changePlatformCount = platformSkuService.getChangedPlatformSkuCount(beginTime);
        int beginPage = 0;
        int pageSize = 1000;
        log.info("增量同步的数量为："+changePlatformCount);
        while(beginPage * pageSize < changePlatformCount){
            List<PlatformSku> lists = platformSkuService.getChangedPlatformSkuList(beginTime,beginPage,pageSize);
            for(PlatformSku sku : lists){
                MedicineSPU spu = medicineSPUService.getBySpuCode(sku.getSpuCode());

                EsPlatformSku esSku = new EsPlatformSku();
                esSku.setCommonName(spu.getCommonName());
                esSku.setApprovalCode(spu.getApprovalCode());
                esSku.setSpec(spu.getSpec());
                esSku.setSpuCode(sku.getSpuCode());
                esSku.setFactoryName(spu.getFactoryName());
                esSku.setShortName(spu.getShortName());
                esSku.setFormalName(spu.getFormalName());
                esSku.setBarCode(spu.getBarCode());
                esSku.setId(sku.getId());
                esSku.setCompanyId(sku.getCompanyId());
                esSku.setCompanyName(sku.getCompanyName());
                esSku.setSkuCode(sku.getSkuCode());
                esSku.setStatus(sku.getStatus());
                esPlatformSkuDao.save(esSku);
            }
            beginPage = beginPage + 1;
        }
    }
}
