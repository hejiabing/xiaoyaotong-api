package com.xiaoyaotong.api.search.vo;

/**
 * @author ：billHe
 * @description：搜索sku传递的参数，包装成vo
 * @date ：2019/12/7 3:26 PM
 */
public class QuerySpuVO {
    private String commonName;
    private String approvalCode;
    private String barCode;
    private String factoryName;
    private Integer pageSize;
    private Integer startPage;


    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }
}
