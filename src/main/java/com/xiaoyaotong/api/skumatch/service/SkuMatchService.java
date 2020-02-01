package com.xiaoyaotong.api.skumatch.service;

import com.xiaoyaotong.api.search.entity.EsMedicineSpu;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2020/1/31 7:50 PM
 */
public interface SkuMatchService {

    //匹配
    public void matchSku();

    //根据国药准字进行匹配
    public List<EsMedicineSpu> matchByApprovalCode(String approvalCode);

    //根据规格进行匹配
    public void matchBySpec();
}
