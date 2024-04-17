package org.learn.security.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String userName;
  private String password;

  private List<Role> roles;
}
