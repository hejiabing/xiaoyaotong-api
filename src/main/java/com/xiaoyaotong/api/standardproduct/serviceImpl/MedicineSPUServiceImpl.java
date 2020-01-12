package com.xiaoyaotong.api.standardproduct.serviceImpl;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.mapper.MedicineSPUMapper;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import com.xiaoyaotong.api.util.GenerateUniqueIdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public MedicineSPU getBySpuCode(String spuCode) {
        return medicineSPUMapper.findMedicineBySpuCode(spuCode);
    }

    @Override
    public List<String> getAllSPUCode() {
         return  medicineSPUMapper.getAllSPUCodes();
    }

    @Override
    public int getCountofAllSpus() {
        return medicineSPUMapper.getCountofAllSpus();
    }

    @Override
    public List<MedicineSPU> getSPUList(int pageBegin, int pageNum) {
        HashMap hashMap = new HashMap();
        int itemBegin = pageBegin - 1;
        if(itemBegin<0) itemBegin =0;

        hashMap.put("itemBegin",itemBegin * pageNum);
        hashMap.put("pageNum",pageNum);
        return medicineSPUMapper.getSPUList(hashMap);
    }

    @Override
    public List<MedicineSPU> getSPUListByMinimumId(int minimumId,int pageSize) {
        return medicineSPUMapper.getSpusByminumumId(minimumId,pageSize);
    }

    @Override
    public List<MedicineSPU> getChangedSPU(Date beginTime, int beginPage, int pageSize) {
        return medicineSPUMapper.getChangedSPU(beginTime,beginPage,pageSize);
    }

    @Override
    public int getChangedSPUCount(Date beginTime) {
        return medicineSPUMapper.getChangedSPUCount(beginTime);
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
        int result = medicineSPUMapper.deleteMedicineSPU(medicineSPU.getId(),medicineSPU.getSpuCode());
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public int addMedicineSPU(MedicineSPU medicineSPU) {
        //产生1个20位的ID
        String longId = GenerateUniqueIdUtil.getGuid();
        String spuCode = "D"+longId;
        System.out.println(spuCode);
        medicineSPU.setSpuCode(spuCode);
        medicineSPU.setId(0);
        return medicineSPUMapper.insertMedicineSPU(medicineSPU);
    }

    @Override
    public List<MedicineSPU> getSpuByKeyParameters(String spuCode, String commonName, String approvalCode, String barCode) {
        return medicineSPUMapper.getSpuByKeyParameters(spuCode, commonName,approvalCode,barCode);
    }
}
