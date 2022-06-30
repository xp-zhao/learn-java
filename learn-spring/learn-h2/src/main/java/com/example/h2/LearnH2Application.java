package com.example.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.**.dao"})
public class LearnH2Application {

  public static void main(String[] args) {
    SpringApplication.run(LearnH2Application.class, args);
  }
}
