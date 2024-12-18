package org.learn.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xp-zhao
 * @description
 * @date 2024/12/17 20:30
 */
@EnableCaching
@SpringBootApplication
public class RbacApplication {
  public static void main(String[] args) {
    SpringApplication.run(RbacApplication.class, args);
  }
}
