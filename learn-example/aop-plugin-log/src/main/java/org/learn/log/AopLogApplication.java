package org.learn.log;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@SpringBootApplication
public class AopLogApplication implements ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(AopLogApplication.class);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {}
}
