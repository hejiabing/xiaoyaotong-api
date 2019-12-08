package com.xiaoyaotong.api.companyitem.vo;

/**
 * @author ：billHe
 * @description：用于对码的查询
 * @date ：2019/12/7 3:26 PM
 */
public class QueryCompanySkuVO {
    private String CommonName;
    private String approvalCode;
    private String barCode;
    private String factoryName;
    private int companyId;
    private String companySkuCode;
    private String spu;
    private int pageSize;
    private int startPage;
    private int matched;//是否已经匹配

    public int getMatched() {
        return matched;
    }

    public void setMatched(int matched) {
        this.matched = matched;
    }

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setCommonName(String commonName) {
        CommonName = commonName;
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

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
}
