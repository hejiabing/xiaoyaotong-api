package com.xiaoyaotong.api.search.serviceImpl;

import com.xiaoyaotong.api.search.dao.ESMedicineSpuDao;
import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.service.ESSpuSynService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/3 11:11 PM
 */
@Service
public class ESSpuSynServiceImpl implements ESSpuSynService {

    @Autowired
    MedicineSPUService medicineSPUService;

    @Autowired
    ESMedicineSpuDao esMedicineSpuDao;

    @Override
    public void synAllSpu() {

        int count = medicineSPUService.getCountofAllSpus();
        int beginIter = 0;
        int pageSize = 1000;
        //分页获取数据
        while(beginIter * pageSize < count){
            List<MedicineSPU> lists = medicineSPUService.getSPUList(beginIter,pageSize);
            //同步spu到ES
            for(MedicineSPU spu : lists){
                ESMedicineSpu esSpu = new ESMedicineSpu();
                esSpu.setCommonName(spu.getCommonName());
                esSpu.setApprovalCode(spu.getApprovalCode());
                esSpu.setSpec(spu.getSpec());
                esSpu.setSpuCode(spu.getSpuCode());
                esSpu.setFactoryName(spu.getFactoryName());
                esSpu.setShortName(spu.getShortName());
                esSpu.setFormalName(spu.getFormalName());
                esSpu.setId(spu.getId());
                esMedicineSpuDao.save(esSpu);
            }
            beginIter=beginIter+1;
        }
    }
}
