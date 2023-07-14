package com.qianfeng.service;

import com.qianfeng.domain.Role;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 16:26
 * 描述：TODO
 */
public interface IRoleService {
    List<Role> findAll(Integer page, Integer pageSize);

    void addRole(Role role);

    Role findById(String id);

    void update(Role role);

    List<Role> findUserByIdAndAllRole(String id);
}
