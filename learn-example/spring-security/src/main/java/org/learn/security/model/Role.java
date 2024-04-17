package org.learn.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.learn.security.common.enums.RoleType;

/**
 * 角色
 *
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  private RoleType roleType;
}
