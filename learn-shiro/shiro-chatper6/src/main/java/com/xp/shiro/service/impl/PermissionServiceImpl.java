package com.xp.shiro.service.impl;

import com.xp.shiro.dao.PermissionDao;
import com.xp.shiro.dao.PermissionDaoImpl;
import com.xp.shiro.entity.Permission;
import com.xp.shiro.service.PermissionService;

public class PermissionServiceImpl implements PermissionService
{

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
