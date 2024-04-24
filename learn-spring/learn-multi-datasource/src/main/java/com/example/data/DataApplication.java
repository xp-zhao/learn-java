package com.example.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhaoxiaoping
 * @date 2024-4-24
 */
@Slf4j
@SpringBootApplication
public class DataApplication implements CommandLineRunner {

  private final JdbcTemplate jdbcTemplateOne;
  private final JdbcTemplate jdbcTemplateTwo;
  private final JdbcTemplate defaultJdbcTemplate;

  public DataApplication(
      @Qualifier("jdbcTemplateOne") JdbcTemplate templateOne,
      @Qualifier("jdbcTemplateTwo") JdbcTemplate templateTwo,
      JdbcTemplate defaultTemplate) {
    this.jdbcTemplateOne = templateOne;
    this.jdbcTemplateTwo = templateTwo;
    this.defaultJdbcTemplate = defaultTemplate;
  }

  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    jdbcTemplateOne
        .queryForList("SELECT * FROM USER_INFO")
        .forEach(row -> log.info(row.toString()));
    log.info("----");
    jdbcTemplateTwo
        .queryForList("SELECT * FROM USER_INFO")
        .forEach(row -> log.info(row.toString()));
    log.info("----");
    defaultJdbcTemplate
        .queryForList("SELECT * FROM USER_INFO")
        .forEach(row -> log.info(row.toString()));
  }
}
