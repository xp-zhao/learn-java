package com.xp.shiro.dao;

import com.xp.shiro.entity.Permission;

public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
