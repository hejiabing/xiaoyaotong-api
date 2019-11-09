package com.xiaoyaotong.api.standardproduct.service;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/8 9:16
 */
public interface MedicineSPUService {
    MedicineSPU getSPUByspuid(int spuid);

    List<Integer> getAllSPUid();

    //获取SPU list，分页获取
    List<MedicineSPU> getSPUList(int pageBegin,int pageNum);

    boolean insertMedicineSPU(MedicineSPU medicineSPU);

    boolean updateMedicineSPU(MedicineSPU medicineSPU);

    boolean deleteMedicineSPU(MedicineSPU medicineSPU);



}
