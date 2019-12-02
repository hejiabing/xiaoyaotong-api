package com.xiaoyaotong.api.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author ：billHe
 * @description：可以销卖的SKU搜索
 * @date ：2019/12/2 9:48 PM
 */
@Document(indexName = "xiaoyaotong",type = "sku")
public class ESPlatformSku {

    @Id
    private int id;

    //spu的信息
    @Field
    private String spuCode;// spu code
    @Field
    private String commonName; //通用名
    @Field
    private String approvalCode; //批准文号

    @Field
    private String spec; //规格

    @Field
    private String factoryName; //生产厂家
    @Field
    private String formalName; //商品名
    @Field
    private String shortName; //别名

    //sku的信息
    @Field
    private String skuCode;//sku code
    @Field
    private String companyId; //卖家id
    @Field
    private String companyName; //卖家名称
    @Field
    private String batchNos; //批号集合
    @Field
    private String deadlineNos; //效期集合
    @Field
    private int stocks;//库存
    @Field
    private double commonPrice; //价格


    public int getId() {
        return id;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public String getSpec() {
        return spec;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getFormalName() {
        return formalName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBatchNos() {
        return batchNos;
    }

    public String getDeadlineNos() {
        return deadlineNos;
    }

    public int getStocks() {
        return stocks;
    }

    public double getCommonPrice() {
        return commonPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBatchNos(String batchNos) {
        this.batchNos = batchNos;
    }

    public void setDeadlineNos(String deadlineNos) {
        this.deadlineNos = deadlineNos;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setCommonPrice(double commonPrice) {
        this.commonPrice = commonPrice;
    }

}
