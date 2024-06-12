package org.learn.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoxiaoping
 * @date 2024-6-11
 */
@SpringBootApplication
public class FlowableApplication {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(FlowableApplication.class);
    app.run(args);
  }
}
