package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.config.Constants;
import com.xiaoyaotong.api.search.dao.EsMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.service.EsSpuSynService;
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
 * @date ：2019/12/3 11:11 PM
 */
@Service
public class EsSpuSynServiceImpl implements EsSpuSynService {

    private static Log log = LogFactory.getLog(EsSpuSynServiceImpl.class);


    @Autowired
    MedicineSPUService medicineSPUService;

    @Autowired
    EsMedicineSpuDao esMedicineSpuDao;

    @Autowired
    private RedisTemplate<String, String> stringRedis;

    @Override
    public void synAllSpu() {
        log.info("SPU全量同步开始！");

        stringRedis.boundValueOps(Constants.ES_ALL_SPU_SYNC).set(Constants.ES_SYNC_BEGIN);
        int count = medicineSPUService.getCountofAllSpus();
        int beginIter = 0;
        int pageSize = 1000;
        int currentMaxId = 0;
        stringRedis.boundValueOps(Constants.ES_ALL_SPU_SYNC).set(Constants.ES_SYNC_DOING);
        //分页获取数据
        log.info("同步数量为："+count);
        while(beginIter * pageSize < count){
            List<MedicineSPU> lists = medicineSPUService.getSPUList(beginIter,pageSize);
            //同步spu到ES
            for(MedicineSPU spu : lists){
                EsMedicineSpu esSpu = new EsMedicineSpu();
                esSpu.setCommonName(spu.getCommonName());
                esSpu.setApprovalCode(spu.getApprovalCode());
                esSpu.setSpec(spu.getSpec());
                esSpu.setSpuCode(spu.getSpuCode());
                esSpu.setFactoryName(spu.getFactoryName());
                esSpu.setShortName(spu.getShortName());
                esSpu.setFormalName(spu.getFormalName());
                esSpu.setBarCode(spu.getBarCode());
                esSpu.setId(spu.getId());
                esMedicineSpuDao.save(esSpu);
                currentMaxId = currentMaxId > spu.getId()?currentMaxId : spu.getId(); //得到最大的minimumId

            }
            beginIter=beginIter + 1;
        }
        stringRedis.boundValueOps(Constants.ES_ALL_SPU_SYNC).set(Constants.ES_SYNC_FINISHED);
        stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC_MAXID).set("" + currentMaxId);
        log.info("SPU全量同步结束！");
    }

    @Override
    public void synIncrementSpu() {

        log.info("SPU增量同步开始！");
        //获取Redis里面的增量同步的当前状态
        String currentStatus = stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC).get();

        if(null==currentStatus || "".equals(currentStatus)){
            stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC).set(Constants.ES_SYNC_FINISHED);
        }

        if(currentStatus.equals(Constants.ES_SYNC_FINISHED)){ //处于完成状态才同步
            stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC).set(Constants.ES_SYNC_BEGIN);

            //获取Redis里面的增量同步的当前状态
            String minimumId = stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC_MAXID).get();//获取最大的id

            if(null==minimumId || "".equals(minimumId)){
                stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC_MAXID).set("0");
                minimumId = "0";
            }

            //准备同步
            stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC).set(Constants.ES_SYNC_BEGIN);

            int minimum = Integer.valueOf(minimumId);
            int pageSize = 2000;
            int currentMaxId = 0;
            List<MedicineSPU> lists = medicineSPUService.getSPUListByMinimumId(minimum,pageSize);
            log.info(lists.size());
            for(MedicineSPU spu : lists){
                EsMedicineSpu esSpu = new EsMedicineSpu();
                esSpu.setCommonName(spu.getCommonName());
                esSpu.setApprovalCode(spu.getApprovalCode());
                esSpu.setSpec(spu.getSpec());
                esSpu.setSpuCode(spu.getSpuCode());
                esSpu.setFactoryName(spu.getFactoryName());
                esSpu.setShortName(spu.getShortName());
                esSpu.setFormalName(spu.getFormalName());
                esSpu.setBarCode(spu.getBarCode());
                esSpu.setId(spu.getId());
                esMedicineSpuDao.save(esSpu);
                currentMaxId = currentMaxId > spu.getId()?currentMaxId : spu.getId(); //得到最大的minimumId
                stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC_MAXID).set("" + currentMaxId);
            }

            log.info(currentMaxId);
            //同步结束
            stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC).set(Constants.ES_SYNC_FINISHED);
            stringRedis.boundValueOps(Constants.ES_INCREMENT_SPU_SYNC_MAXID).set("" + currentMaxId);
            log.info("SPU增量同步结束！");
        }

    }
}
