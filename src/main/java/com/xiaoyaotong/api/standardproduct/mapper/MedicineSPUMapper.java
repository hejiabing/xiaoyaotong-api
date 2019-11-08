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

    public MedicineSPU findMedicineSPUByID(long spuid);

    public List<Integer> getAllSPUIds();

    public List<MedicineSPU> getSPUList(HashMap hashMap);
}
