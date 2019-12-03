package com.xiaoyaotong.api.platform.entity;

import java.math.BigDecimal;

public class PlatformSku {

  private long id;
  private long skuId;//自动生成的唯一的skuid
  private long spuId;//标品库的spuid
  private long sellerId; //卖家的id，companyid
  private String companySkuCode; // 卖家的sku编码
  private String companyName; //公司名称
  private String batchNos; //批号集合
  private String deadlineNos; //效期集合
  private int stocks; //库存数量，可销售数量
  private BigDecimal commonPrice; //价格
  private long status;
  private String createUser;
  private java.sql.Timestamp createTime;
  private String updateUser;
  private java.sql.Timestamp updateTime;

  public String getDeadlineNos() {
    return deadlineNos;
  }

  public void setDeadlineNos(String deadlineNos) {
    this.deadlineNos = deadlineNos;
  }


  public String getBatchNos() {
    return batchNos;
  }

  public int getStocks() {
    return stocks;
  }

  public void setBatchNos(String batchNos) {
    this.batchNos = batchNos;
  }

  public void setStocks(int stocks) {
    this.stocks = stocks;
  }

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


  public String getCompanySkuCode() {
    return companySkuCode;
  }

  public void setCompanySkuCode(String sellerSkuCode) {
    this.companySkuCode = companySkuCode;
  }


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public BigDecimal getCommonPrice() {
    return commonPrice;
  }

  public void setCommonPrice(BigDecimal commonPrice) {
    this.commonPrice = commonPrice;
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
