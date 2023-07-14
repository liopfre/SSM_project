package com.qianfeng.service;

import com.qianfeng.domain.Permissions;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 18:45
 * 描述：TODO
 */
public interface IPermissionService {

    List<Permissions> findAll(Integer page, Integer pageSize);

    void addPermission(Permissions permissions);

    List<Permissions> findPermissionsByRoleId(String id);

    void addRoleToPermission(String roleId, String[] ids);
}
