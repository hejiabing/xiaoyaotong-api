package com.xiaoyaotong.api.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ：billHe
 * @description：可以销卖的SKU搜索
 * es 7.0以后支持一个index一个type, 8.0以后会去掉type
 * @date ：2019/12/2 9:48 PM
 *
 */
@Document(indexName = "sku",type = "sku")
public class EsPlatformSku implements Serializable {

    @Id
    private long id;

    //spu的信息
    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String spuCode;// spu code

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String commonName; //通用名

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String approvalCode; //批准文号

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String spec; //规格

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String factoryName; //生产厂家

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String formalName; //商品名

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String shortName; //别名

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String barCode; //条形码

    //sku的信息
    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String skuCode;//sku code

    @Field(type = FieldType.Integer)
    private int companyId; //卖家id

    @Field(type = FieldType.Text,analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String companyName; //卖家名称

    @Field(type = FieldType.Text,index = false)
    private String batchNos; //批号集合

    @Field(type = FieldType.Text,index = false)
    private String deadlineNos; //效期集合

    @Field(type = FieldType.Integer,index = false)
    private int stocks;//库存

    @Field(type = FieldType.Double,index = false)
    private BigDecimal commonPrice; //价格

    @Field(type = FieldType.Integer)
    private Integer status; //上下架状态


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBatchNos() {
        return batchNos;
    }

    public void setBatchNos(String batchNos) {
        this.batchNos = batchNos;
    }

    public String getDeadlineNos() {
        return deadlineNos;
    }

    public void setDeadlineNos(String deadlineNos) {
        this.deadlineNos = deadlineNos;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public BigDecimal getCommonPrice() {
        return commonPrice;
    }

    public void setCommonPrice(BigDecimal commonPrice) {
        this.commonPrice = commonPrice;
    }
}
