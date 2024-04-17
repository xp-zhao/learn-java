package org.learn.security.support;

import lombok.RequiredArgsConstructor;
import org.learn.security.model.User;
import org.learn.security.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUserByName(username);
    return new UserDetailsImpl(user);
  }
}
