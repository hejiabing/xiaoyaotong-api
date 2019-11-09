package com.xiaoyaotong.api.standardproduct.mapper;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/8 8:57
 */
@Repository
public interface MedicineSPUMapper {

    //根据spuid查询
    public MedicineSPU findMedicineSPUByID(long spuid);

    public List<Integer> getAllSPUIds();

    //根据传入的起始和数目查询SPU，分页
    public List<MedicineSPU> getSPUList(HashMap hashMap);

    //插入不包含图片的SPU
    public int insertMedicineSPU(MedicineSPU medicineSPU);

    //逻辑删除，更改状态位
    public int deleteMedicineSPU(long id, long spuId);

    //更新
    public int updateMedicineSPU(MedicineSPU medicineSPU);

}
