package com.example.feature;

import com.example.feature.register.EnableOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableOperator
// @ComponentScan(
//    useDefaultFilters = false,
//    includeFilters =
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = TestAnnotation.class))
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
