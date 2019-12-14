package com.xiaoyaotong.api.platform.vo;

import java.io.Serializable;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/7 3:26 PM
 */
public class QueryPlatformSkuVO {
    private String CommonName;
    private String approvalCode;
    private String barCode;
    private String factoryName;
    private int companyId;
    private String companySkuCode;
    private int pageSize;
    private int startPage;

    public String getCommonName() {
        return CommonName;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setCommonName(String commonName) {
        CommonName = commonName;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }
}
