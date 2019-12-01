package com.xiaoyaotong.api.companyitem.entity;

/**
 *
 * 本实体类存放的是商家同步过来的药品
 */

public class CompanySku {

  private int id;//自增id
  private int companyId; //公司的id
  private String skuCode; //公司自己的ERP编码
  private String commonName; //通用名
  private String approvalCode; //国药准字
  private String spec; //规格
  private String factoryName; //生产厂家
  private String barCode; //条形码
  private long standardSpu; //匹配上的标准库里面的编码
  private boolean matched; //是否完全匹配上
  private int matchCount; //匹配的次数
  private String createUser; //创建人
  private String updateUser; //更新人
  private java.sql.Timestamp createTime;//创建时间
  private java.sql.Timestamp updateTime;//更新时间
    private long status;


  public int getMatchCount() {
    return matchCount;
  }

  public boolean isMatched() {
    return matched;
  }

  public void setMatchCount(int matchCount) {
    this.matchCount = matchCount;
  }

  public void setMatched(boolean matched) {
    matched = matched;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }

  public int getCompanyId() {
    return companyId;
  }




  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCompayId() {
    return companyId;
  }

  public void setCompayId(int compayId) {
    this.companyId = compayId;
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

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

  public long getStandardSpu() {
    return standardSpu;
  }

  public void setStandardSpu(long standardSpu) {
    this.standardSpu = standardSpu;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

public String getSkuCode() {
	return skuCode;
}

public void setSkuCode(String skuCode) {
	this.skuCode = skuCode;
}

}
