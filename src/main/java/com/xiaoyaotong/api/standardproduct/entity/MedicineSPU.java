package com.xiaoyaotong.api.standardproduct.entity;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/7 10:25 PM
 */
public class MedicineSPU {
    private int id;
    private int spuId;
    private String commonName;
    private String approvalCode;
    private String spec;
    private String factoryName;
    private String formalName;
    private String shortName;
    private String firstCategory;
    private String secondCategory;
    private long isStandard;
    private long status;
    private String createUser;
    private java.sql.Timestamp createTime;
    private String updateUser;
    private java.sql.Timestamp updateTime;
    private String barCode;
    private List<MedicineSPUPic> pics;

    public List<MedicineSPUPic> getPics() {
        return pics;
    }

    public void setPics(List<MedicineSPUPic> pics) {
        this.pics = pics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpuId() {
        return spuId;
    }

    public void setSpuId(int spuId) {
        this.spuId = spuId;
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

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public long getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(long isStandard) {
        this.isStandard = isStandard;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString(){
        return
                "spuId:" + this.getSpuId() +
                ",ApprovalCode:" + this.getApprovalCode() +
                ",spec:" + this.getSpec() +
                ",CommonName:" + this.getCommonName()+
                ",FactoryName:" + this.getFactoryName() +
                ",pics:" + this.getPics().size();
    }
}
