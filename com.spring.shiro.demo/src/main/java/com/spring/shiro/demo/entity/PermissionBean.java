package com.spring.shiro.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hushixian
 * @date 2019-04-29 18:26
 */
public class PermissionBean implements Serializable {

    private String id;

    private String mId;

    private String mPId;

    private String mName;

    private String mValue;

    private String mUrl;

    private String mIcon;

    private String mDes;

    private String createPerson;

    private Date createTime;

    private Date updateTime;

    private String sortCode;

    private String status;

    private Integer isDel;

    public PermissionBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPId() {
        return mPId;
    }

    public void setmPId(String mPId) {
        this.mPId = mPId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
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

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", mId='" + mId + '\'' +
                ", mPId='" + mPId + '\'' +
                ", mName='" + mName + '\'' +
                ", mValue='" + mValue + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mIcon='" + mIcon + '\'' +
                ", mDes='" + mDes + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sortCode='" + sortCode + '\'' +
                ", status='" + status + '\'' +
                ", isDel=" + isDel;
    }
}
