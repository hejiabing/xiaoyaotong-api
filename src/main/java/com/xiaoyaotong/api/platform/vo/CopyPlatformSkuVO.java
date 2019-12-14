package com.xiaoyaotong.api.platform.vo;

import java.math.BigDecimal;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/14 3:45 PM
 */
public class CopyPlatformSkuVO {
    private String skuCode; //skucode
    private String companyId ; //公司id
    private String companySkuCode;//公司的erpId
    private int validMonthStart; //效期的开始时间
    private int validMonthEnd; //效期的结束时间
    private BigDecimal price; //价格
    private int stocks; //库存

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
    }

    public int getValidMonthStart() {
        return validMonthStart;
    }

    public void setValidMonthStart(int validMonthStart) {
        this.validMonthStart = validMonthStart;
    }

    public int getValidMonthEnd() {
        return validMonthEnd;
    }

    public void setValidMonthEnd(int validMonthEnd) {
        this.validMonthEnd = validMonthEnd;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}
