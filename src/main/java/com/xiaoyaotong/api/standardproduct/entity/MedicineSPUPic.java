package com.xiaoyaotong.api.standardproduct.entity;

/**
 * @author ：billHe
 * @description：该类是和标品库绑定的的图片url
 *
 * @date ：2019/11/8 8:42 PM
 */
public class MedicineSPUPic {
    private long id;//自动生成的id
    private String spuCode; //标品库的spuCode
    private String picUrl; //图片的url
    private long status; //状态
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


    public String getSpuId() {
        return spuCode;
    }

    public void setSpuId(String spuId) {
        this.spuCode = spuCode;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
