package com.xiaoyaotong.api.search.vo;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 6:09 PM
 */
public class CompanyItemVO {
    private String companySkuCode;

    private CompanySku companySku;

    private MedicineSPU spu;

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }

    public CompanySku getCompanySku() {
        return companySku;
    }

    public void setCompanySku(CompanySku companySku) {
        this.companySku = companySku;
    }

    public MedicineSPU getSpu() {
        return spu;
    }

    public void setSpu(MedicineSPU spu) {
        this.spu = spu;
    }
}
