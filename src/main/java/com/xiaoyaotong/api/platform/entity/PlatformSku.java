package com.xiaoyaotong.api.platform.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PlatformSku {

  private Integer id;
  private String skuCode;//自动生成的唯一的skuid
  private String spuCode;//标品库的spucode
  private Integer companyId; //卖家的id，companyid
  private String companySkuCode; // 卖家的sku编码
  private String companyName; //公司名称
  private String batchNos; //批号集合
  private String deadlineNos; //效期集合
  private Integer stocks; //库存数量，可销售数量
  private BigDecimal commonPrice; //价格
  private Integer validMonthStart; //效期集合的开始时间
  private Integer validMonthEnd;//效期集合的结束时间
  private Integer status;
  private String createUser;
  private java.util.Date createTime;
  private String updateUser;
  private java.util.Date updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSkuCode() {
    return skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
  }

  public String getSpuCode() {
    return spuCode;
  }

  public void setSpuCode(String spuCode) {
    this.spuCode = spuCode;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getCompanySkuCode() {
    return companySkuCode;
  }

  public void setCompanySkuCode(String companySkuCode) {
    this.companySkuCode = companySkuCode;
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

  public Integer getStocks() {
    return stocks;
  }

  public void setStocks(Integer stocks) {
    this.stocks = stocks;
  }

  public BigDecimal getCommonPrice() {
    return commonPrice;
  }

  public void setCommonPrice(BigDecimal commonPrice) {
    this.commonPrice = commonPrice;
  }

  public Integer getValidMonthStart() {
    return validMonthStart;
  }

  public void setValidMonthStart(Integer validMonthStart) {
    this.validMonthStart = validMonthStart;
  }

  public Integer getValidMonthEnd() {
    return validMonthEnd;
  }

  public void setValidMonthEnd(Integer validMonthEnd) {
    this.validMonthEnd = validMonthEnd;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
