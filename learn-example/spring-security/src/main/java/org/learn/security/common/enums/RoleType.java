package org.learn.security.common.enums;

/**
 * 角色枚举
 *
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
public enum RoleType {
  ADMIN("admin"),
  USER("user");

  private String roleName;

  RoleType(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName() {
    return roleName;
  }
}
