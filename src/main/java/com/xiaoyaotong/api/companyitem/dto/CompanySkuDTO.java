package com.xiaoyaotong.api.companyitem.dto;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;

import java.io.Serializable;

/**
 * @author ：billHe
 * @description：这是返回给对码页面的信息
 * @date ：2019/12/7 3:11 PM
 */
public class CompanySkuDTO implements Serializable {

    private int companyId; //公司id
    private String companySkuCode;//公司的erp商品编码
    private String factoryName; //生产厂家
    private String commonName;//通用名
    private String spec;//规格
    private String approvalCode;//公司同步的国药准字
    private String barCode;//公司同步的条码
    private MedicineSPU medicineSPU;//对应的标准库信息

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public MedicineSPU getMedicineSPU() {
        return medicineSPU;
    }

    public void setMedicineSPU(MedicineSPU medicineSPU) {
        this.medicineSPU = medicineSPU;
    }
}
