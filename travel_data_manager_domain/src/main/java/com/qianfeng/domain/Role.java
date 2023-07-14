package com.qianfeng.domain;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 3:25
 * 描述：TODO
 */
public class Role {
    String id;
    String roleName;
    String roleDesc;
    List<UserInfo> userInfos;
    List<Permissions> permissions;

    public Role(String id, String roleName, String roleDesc, List<UserInfo> userInfos, List<Permissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.userInfos = userInfos;
        this.permissions = permissions;
    }

    public Role() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", userInfos=" + userInfos +
                ", permissions=" + permissions +
                '}';
    }
}
