package com.spring.shiro.demo.entity;

import java.io.Serializable;
import java.util.*;

/**
 * @author hushixian
 * @date 2019-04-29 18:17
 */
public class RoleBean implements Serializable {

    private String id;

    private String roleId;

    private String roleName;

    private String roleValue;

    private String roleDes;

    private String createPerson;

    private Date createTime;

    private Date updateTime;

    private String sortCode;

    private String status;

    private Integer isDel;

    private List<PermissionBean> permissions = new ArrayList<>();

    public RoleBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes;
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

    public List<PermissionBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionBean> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", roleDes='" + roleDes + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sortCode='" + sortCode + '\'' +
                ", status='" + status + '\'' +
                ", isDel=" + isDel +
                ", permissions=" + permissions;
    }
}
