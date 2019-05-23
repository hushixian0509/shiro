package com.spring.shiro.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hushixian
 * @date 2019-04-29 18:08
 */
public class UserBean implements Serializable {
    // 表Id
    private  String id;
    // 用户id
    private  String userId;
    // 用户名
    private  String userName;
    // 电话
    private  String userTel;
    // 用户账号
    private  String userAccount;
    // 用户密码
    private  String userPassword;
    // 用户职位
    private  String userJob;
    // 所属组织机构Id
    private  String orgId;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 状态码
    private  String status;
    // 是否删除;0,未删除;1,删除
    private  Integer isDel;

    private Set<RoleBean> roles = new HashSet<>();

    public UserBean() {

    }

    public UserBean(String id, String userId, String userName, String userTel,
                    String userAccount, String userPassword, String userJob, String orgId,
                    Date createTime, Date updateTime, String status, Integer isDel, Set<RoleBean> roles) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userJob = userJob;
        this.orgId = orgId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.isDel = isDel;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public Set<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleBean> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userJob='" + userJob + '\'' +
                ", orgId='" + orgId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                ", isDel=" + isDel +
                ", roles=" + roles;
    }
}
