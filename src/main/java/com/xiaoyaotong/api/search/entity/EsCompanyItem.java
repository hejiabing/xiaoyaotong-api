package com.xiaoyaotong.api.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ：billHe
 * @description：商家上传的sku信息
 * es 7.0以后支持一个index一个type, 8.0以后会去掉type
 * @date ：2019/12/2 9:48 PM
 *
 */
@Document(indexName = "companyitem",type = "companyitem")
public class EsCompanyItem implements Serializable {

    @Id
    private int id;

    @Field
    private int companyId; //卖家id
    @Field
    private String companyName; //卖家名称
    @Field
    private String companySkuCode;//
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
    @Field
    private String barCode; //条形码
    @Field
    private String spuCode;

    @Field
    private Integer matched; //是否匹配上

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCompanySkuCode() {
        return companySkuCode;
    }

    public void setCompanySkuCode(String companySkuCode) {
        this.companySkuCode = companySkuCode;
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

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public Integer getMatched() {
        return matched;
    }

    public void setMatched(Integer matched) {
        this.matched = matched;
    }
}
