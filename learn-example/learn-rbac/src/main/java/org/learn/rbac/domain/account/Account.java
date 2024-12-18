package org.learn.rbac.domain.account;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.learn.rbac.domain.BaseEntity;

/**
 * 用户实体
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Getter
@Setter
@Entity
public class Account extends BaseEntity {
  @NotEmpty(message = "用户不允许为空")
  private String username;
}
