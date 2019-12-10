package com.xiaoyaotong.api.search.dao;

import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EsMedicineSpuDao extends CrudRepository<EsMedicineSpu, String> {
    /**
     * 根据通用名查询
     * @param commonName
     * @return
     */
    List<EsMedicineSpu> findByCommonName(String commonName);

    /**
     * 根据国药准字查询
     * @param approvalCode
     * @return
     */
    List<EsMedicineSpu> findByApprovalCode(String approvalCode);

    /**
     * 根据条形码查询
     * @param barCode
     * @return
     */
    List<EsMedicineSpu> findByBarCode(String barCode);


}
