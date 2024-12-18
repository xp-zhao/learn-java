package org.learn.rbac.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * 领域对象的公共基类
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
