package com.xp.shiro.service;

import com.xp.shiro.entity.Permission;

/**
 * Created by xp-zhao on 2018/1/22.
 */
public interface PermissionService
{
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
