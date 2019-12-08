package com.xiaoyaotong.api.companyitem.entity;

import java.util.Date;

/**
 *
 * 本实体类存放的是商家同步过来的药品
 */

public class CompanySku {

  private int id;//自增id
  private int companyId; //公司的id
  private String companySkuCode; //公司自己的ERP编码
  private String commonName; //通用名
  private String approvalCode; //国药准字
  private String spec; //规格
  private String factoryName; //生产厂家
  private String barCode; //条形码
  private String spuCode; //匹配上的标准库里面的编码
  private int matched; //是否完全匹配上
  private int matchCount; //匹配的次数
  private String createUser; //创建人
  private String updateUser; //更新人
  private java.util.Date createTime;//创建时间
  private java.util.Date updateTime;//更新时间
  private long status;

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

  public int getMatched() {
    return matched;
  }

  public void setMatched(int matched) {
    this.matched = matched;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public void setMatchCount(int matchCount) {
    this.matchCount = matchCount;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }
}
