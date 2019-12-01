package com.xiaoyaotong.api.standardproduct.entity;

import java.util.List;

/**
 * @author ：billHe
 * @description：这个是药品的标准库 entity
 * @date ：2019/11/7 10:25 PM
 */
public class MedicineSPU {
    private int id;//自增生成的id
    private String spuCode; //标品的code
    private String commonName; //通用名
    private String approvalCode;//国药准字
    private String spec; //规格
    private String factoryName; //生产厂家
    private String formalName; // 商品名
    private String shortName;  //别名
    private String firstCategory; //一级目录
    private String secondCategory; //二级目录
    private long isStandard; //是否已经是经过确认标品
    private long status; //当前状态：录入，审核，完成。
    private String createUser; //创建人
    private java.sql.Timestamp createTime; //创建时间
    private String updateUser; //更新人
    private java.sql.Timestamp updateTime; //更新时间
    private String barCode;  //标品上的条码
    private List<MedicineSPUPic> pics; //图片

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
                "spuId:" + this.getSpuCode() +
                ",ApprovalCode:" + this.getApprovalCode() +
                ",spec:" + this.getSpec() +
                ",CommonName:" + this.getCommonName()+
                ",FactoryName:" + this.getFactoryName() +
                ",pics:" + this.getPics().size();
    }
}
