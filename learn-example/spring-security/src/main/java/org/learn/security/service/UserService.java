package org.learn.security.service;

import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.learn.security.common.enums.RoleType;
import org.learn.security.model.Role;
import org.learn.security.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Service
public class UserService {
  @Resource PasswordEncoder passwordEncoder;

  public User getUserByName(String username) {
    if (StrUtil.isBlank(username)) {
      throw new RuntimeException("用户不存在");
    }
    List<Role> roles = new ArrayList<>();
    roles.add(new Role(RoleType.USER));
    if ("admin".equals(username)) {
      roles.add(new Role(RoleType.ADMIN));
    }
    return new User(username, passwordEncoder.encode("12345"), roles);
  }
}
