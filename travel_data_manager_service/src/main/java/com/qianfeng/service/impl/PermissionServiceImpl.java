package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IPermissionDao;
import com.qianfeng.domain.Permissions;
import com.qianfeng.service.IPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 18:46
 * 描述：TODO
 */
@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    IPermissionDao iPermissionDao;
    @Override
    public List<Permissions> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Permissions> permissions=iPermissionDao.findAll();
        return permissions;
    }

    @Override
    public void addPermission(Permissions permissions) {
        String uuid = UUID.randomUUID().toString();
        permissions.setId(uuid);
        iPermissionDao.addPermission(permissions);
    }

    @Override
    public List<Permissions> findPermissionsByRoleId(String id) {
        return iPermissionDao.findPermissionsByRoleId(id);
    }

    @Override
    public void addRoleToPermission(String roleId, String[] ids) {
        for (String id : ids) {
            iPermissionDao.addRoleToPermission(roleId,id);
        }
    }
}
