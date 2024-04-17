package org.learn.security.support;

import javax.annotation.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

  @Resource private PasswordEncoder passwordEncoder;
  @Resource private UserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = String.valueOf(authentication.getPrincipal());
    String password = String.valueOf(authentication.getCredentials());

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    if (passwordEncoder.matches(password, userDetails.getPassword())) {
      return new UsernamePasswordAuthenticationToken(
          username, password, userDetails.getAuthorities());
    }
    throw new BadCredentialsException("Error!!");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.equals(authentication);
  }
}
