package com.xiaoyaotong.api.standardproduct.serviceImpl;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.mapper.MedicineSPUMapper;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/8 9:18
 */
@Service
public class MedicineSPUServiceImpl implements MedicineSPUService {

    @Resource
    private MedicineSPUMapper medicineSPUMapper;
    @Override
    public MedicineSPU getSPUByspuid(int spuid) {
        return medicineSPUMapper.findMedicineSPUByID(spuid);
    }

    @Override
    public List<Integer> getAllSPUid() {
         return  medicineSPUMapper.getAllSPUIds();
    }

    @Override
    public List<MedicineSPU> getSPUList(int pageBegin, int pageNum) {
        HashMap hashMap = new HashMap();
        int itemBegin = pageBegin - 1;
        if(itemBegin<0) itemBegin =0;

        hashMap.put("itemBegin",itemBegin*pageNum);
        hashMap.put("pageNum",pageNum);
        return medicineSPUMapper.getSPUList(hashMap);
    }

    @Override
    public boolean insertMedicineSPU(MedicineSPU medicineSPU) {
        int result = medicineSPUMapper.insertMedicineSPU(medicineSPU);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMedicineSPU(MedicineSPU medicineSPU) {
        int result = medicineSPUMapper.updateMedicineSPU(medicineSPU);
        if(result>0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteMedicineSPU(MedicineSPU medicineSPU) {
        int result = medicineSPUMapper.deleteMedicineSPU(medicineSPU.getId(),medicineSPU.getSpuId());
        if(result>0){
            return true;
        }
        return false;
    }

}
