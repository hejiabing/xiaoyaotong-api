package com.xiaoyaotong.api.platform.dto;

import java.io.Serializable;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/7 3:11 PM
 */
public class PlatformSkuDTO implements Serializable {

    private String factoryName;

    private String barCode;

    private int companyId;

    private String skuCode;

    private String commonName;

    private String spec;

    private String approvalCode;

    private String companySkuCode;

    private String spuCode;

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getSpec() {
        return spec;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }


    public String getCompanySkuCode() {
        return companySkuCode;
    }







}
