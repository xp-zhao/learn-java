package org.learn.security.config;

import javax.annotation.Resource;
import org.learn.security.support.JwtAuthenticationProvider;
import org.learn.security.support.JwtAuthenticationTokenFilter;
import org.learn.security.support.MyAccessDeniedHandler;
import org.learn.security.support.MyUnauthorizedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  @Resource private MyUnauthorizedHandler unauthorizedHandler;

  @Resource private MyAccessDeniedHandler accessDeniedHandler;

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
      throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
    return new JwtAuthenticationTokenFilter();
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider() {
    return new JwtAuthenticationProvider();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.authorizeRequests().expressionHandler(webExpressionHandler());
    // 由于使用的是JWT，这里不需要csrf防护
    httpSecurity
        .csrf(CsrfConfigurer::disable)
        // 基于token，所以不需要session
        .sessionManagement(
            sessionManagementConfigurer ->
                sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            authorizationRegistry ->
                authorizationRegistry
                    // 允许对于网站静态资源的无授权访问
                    .antMatchers(HttpMethod.GET, "/", "/*.html")
                    .permitAll()
                    // 对登录注册允许匿名访问
                    .antMatchers("/auth/login", "/auth/register", "/test/**")
                    .permitAll()
                    // 跨域请求会先进行一次options请求
                    .antMatchers(HttpMethod.OPTIONS)
                    .permitAll()
                    // 除上面外的所有请求全部需要鉴权认证
                    .anyRequest()
                    .authenticated())
        // 禁用缓存
        .headers(
            headersConfigurer ->
                headersConfigurer.cacheControl(HeadersConfigurer.CacheControlConfig::disable))
        // 使用自定义provider
        .authenticationProvider(jwtAuthenticationProvider())
        // 添加JWT filter
        .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
        // 添加自定义未授权和未登录结果返回
        .exceptionHandling(
            exceptionConfigurer ->
                exceptionConfigurer
                    .accessDeniedHandler(accessDeniedHandler)
                    .authenticationEntryPoint(unauthorizedHandler));
    return httpSecurity.build();
  }

  @Bean
  static GrantedAuthorityDefaults grantedAuthorityDefaults() {
    // 自定义基于角色的授权规则所使用的前缀, 默认角色名是 ROLE_XXX
    return new GrantedAuthorityDefaults("");
  }
}
