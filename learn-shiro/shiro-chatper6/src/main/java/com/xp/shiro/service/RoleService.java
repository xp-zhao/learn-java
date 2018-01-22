package com.xp.shiro.service;

import com.xp.shiro.entity.Role;

/**
 * Created by xp-zhao on 2018/1/22.
 */
public interface RoleService
{
	public Role createRole(Role role);
	public void deleteRole(Long roleId);

	/**
	 * 添加角色-权限之间关系
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(Long roleId, Long... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
