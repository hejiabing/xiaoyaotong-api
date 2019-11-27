package com.xiaoyaotong.api.companyitem.entity;


public class CompanySku {

  private int id;
  private int companyId;
  private String productCode;
  private String commonName;
  private String approvalCode;
  private String spec;
  private String factoryName;
  private String barCode;

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductCode() {
    return productCode;
  }


  private long status;

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

  private long standardSpu;

  public int getCompanyId() {
    return companyId;
  }

  private String createUser;
  private String updateUser;

  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


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

  public String getErpId() {
    return productCode;
  }

  public void setErpId(String erpId) {
    this.productCode = erpId;
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

}
