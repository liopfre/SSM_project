package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.dao.IRoleDao;
import com.qianfeng.domain.Role;
import com.qianfeng.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 16:27
 * 描述：TODO
 */
@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements IRoleService {

    @Resource
    IRoleDao iRoleDao;
    @Override
    public List<Role> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Role> roles=iRoleDao.findAll();
        return roles;
    }

    @Override
    public void addRole(Role role) {
        String uuid = UUID.randomUUID().toString();
        role.setId(uuid);
        iRoleDao.addRole(role);
    }

    @Override
    public Role findById(String id) {
        Role role=iRoleDao.findById(id);
        return role;
    }

    @Override
    public void update(Role role) {
        iRoleDao.updateRole(role);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) {
        return iRoleDao.findUserByIdAndAllRole(id);
    }
}
