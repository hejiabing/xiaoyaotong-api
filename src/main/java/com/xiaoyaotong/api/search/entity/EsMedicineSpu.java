package com.xiaoyaotong.api.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author ：billHe
 * @description：标品的document
 * @date ：2019/12/2 7:26 PM
 */
@Data
@Document(indexName = "spu",type="spu")
public class EsMedicineSpu implements Serializable {

    @Field
    private String commonName; //通用名
    @Field
    private String spuCode;// spu code
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
    @Id
    private int id;//id

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
