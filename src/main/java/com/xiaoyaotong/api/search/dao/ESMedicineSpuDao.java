package com.xiaoyaotong.api.search.dao;

import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ESMedicineSpuDao extends CrudRepository<ESMedicineSpu, String> {
    /**
     * 根据通用名查询
     * @param commonName
     * @return
     */
    List<ESMedicineSpu> findByCommonName(String commonName);

    /**
     * 根据国药准字查询
     * @param approvalCode
     * @return
     */
    List<ESMedicineSpu> findByApprovalCode(String approvalCode);

    /**
     * 根据条形码查询
     * @param barCode
     * @return
     */
    List<ESMedicineSpu> findByBarCode(String barCode);


}
