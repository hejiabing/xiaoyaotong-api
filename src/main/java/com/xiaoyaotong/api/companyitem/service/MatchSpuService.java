package com.xiaoyaotong.api.companyitem.service;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;

import java.util.List;

/**
 * @author ：billHe
 * @description：本服务主要用来做标品库的匹配
 * @date ：2019/12/2 10:30 PM
 */
public interface MatchSpuService {

    /**
     * 根据条形码进行匹配
     * @param companySku
     * @return
     */
    public List<EsMedicineSpu> matchSpuWithBarCode(CompanySku companySku);

    /**
     * 根据通用名，规格，生产厂家进行匹配
     * @param companySku
     * @return
     */
    public boolean matchSpuWithAll(CompanySku companySku);


    /**
     * 根据批准文号，规格进行匹配
     * @param companySku
     * @return
     */
    public boolean matchSpuWithApprovalCodeAndSpec(CompanySku companySku);


    /**
     * 根据已有的数据进行匹配
     * @param companySku
     * @return
     */
    public boolean matchSpuWithExistData(CompanySku companySku);

}
