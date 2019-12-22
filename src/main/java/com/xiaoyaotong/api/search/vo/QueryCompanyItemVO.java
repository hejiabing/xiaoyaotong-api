package com.xiaoyaotong.api.search.vo;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 6:01 PM
 */
public class QueryCompanyItemVO {
    private String commonName;
    private String companySkuCode;
    private Integer companyId;
    private Integer startPage;
    private Integer pageSize;
    private Integer matached; //-1未匹配，1匹配，0表示所有

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getMatached() {
        return matached;
    }

    public void setMatached(Integer matached) {
        this.matached = matached;
    }
}
