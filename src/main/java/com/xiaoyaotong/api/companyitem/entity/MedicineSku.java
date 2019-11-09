package com.xiaoyaotong.api.companyitem.entity;

public class MedicineSku {

  private long id;
  private long skuId;
  private long spuId;
  private long sellerId;
  private String sellerSkuCode;
  private String companyName;
  private String deadLine;
  private double commonPrice;
  private long ctlArea;
  private long ctlPrice;
  private long status;
  private String createUser;
  private java.sql.Timestamp createTime;
  private String updateUser;
  private java.sql.Timestamp updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public long getSpuId() {
    return spuId;
  }

  public void setSpuId(long spuId) {
    this.spuId = spuId;
  }


  public long getSellerId() {
    return sellerId;
  }

  public void setSellerId(long sellerId) {
    this.sellerId = sellerId;
  }


  public String getSellerSkuCode() {
    return sellerSkuCode;
  }

  public void setSellerSkuCode(String sellerSkuCode) {
    this.sellerSkuCode = sellerSkuCode;
  }


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  public String getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(String deadLine) {
    this.deadLine = deadLine;
  }


  public double getCommonPrice() {
    return commonPrice;
  }

  public void setCommonPrice(double commonPrice) {
    this.commonPrice = commonPrice;
  }


  public long getCtlArea() {
    return ctlArea;
  }

  public void setCtlArea(long ctlArea) {
    this.ctlArea = ctlArea;
  }


  public long getCtlPrice() {
    return ctlPrice;
  }

  public void setCtlPrice(long ctlPrice) {
    this.ctlPrice = ctlPrice;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
