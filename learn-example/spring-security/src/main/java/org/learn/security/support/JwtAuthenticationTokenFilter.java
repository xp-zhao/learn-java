package org.learn.security.support;

import cn.hutool.jwt.JWTUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.learn.security.common.Constants;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

  private static final String AUTH_HEADER = "Authorization";
  private static final String AUTH_HEADER_TYPE = "Bearer";

  @Resource private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authHeader = request.getHeader(AUTH_HEADER);
    if (Objects.isNull(authHeader) || !authHeader.startsWith(AUTH_HEADER_TYPE)) {
      filterChain.doFilter(request, response);
      return;
    }
    String authToken = authHeader.split(" ")[1];
    log.info("authToken:{}", authToken);
    // verify token
    if (!JWTUtil.verify(authToken, Constants.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))) {
      log.info("invalid token");
      filterChain.doFilter(request, response);
      return;
    }

    // JWTValidator.of(authToken).validateDate();

    final String userName = (String) JWTUtil.parseToken(authToken).getPayload("username");
    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(
            userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(request, response);
  }
}
