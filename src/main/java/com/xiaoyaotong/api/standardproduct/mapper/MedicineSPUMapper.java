package com.xiaoyaotong.api.standardproduct.mapper;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：billHe
 * @description：标品的增删改查
 * @date ：2019/11/8 8:57
 */
@Repository
public interface MedicineSPUMapper {

    //根据spuCode查询
    public MedicineSPU findMedicineBySpuCode(String spuCode);

    public List<String> getAllSPUCodes();

    public int getCountofAllSpus();

    public List<MedicineSPU> getSpuByKeyParameters(@Param("commonName") String commonName,
                                                   @Param("approvalCode")String approvalCode,
                                                   @Param("barCode") String barCode);

    //根据传入的起始和数目查询SPU，分页
    public List<MedicineSPU> getSPUList(HashMap hashMap);

    //插入不包含图片的SPU
    public int insertMedicineSPU(MedicineSPU medicineSPU);

    //逻辑删除，更改状态位
    public int deleteMedicineSPU(long id, String spuCode);

    //更新
    public int updateMedicineSPU(MedicineSPU medicineSPU);


}
