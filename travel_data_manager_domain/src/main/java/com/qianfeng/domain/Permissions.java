package com.qianfeng.domain;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 13:32
 * 描述：TODO
 */
public class Permissions {
    String id;
    String permissionName;
    String url;
    List<Role> roles;

    public Permissions() {
    }

    public Permissions(String id, String permissionName, String url, List<Role> roles) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
