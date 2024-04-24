package com.example.data.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author zhaoxiaoping
 * @date 2024-4-24
 */
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "data-one.datasource")
@MapperScan(
    basePackages = "com.example.data.dao.one",
    sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class DataSourceOneConfig {
  @Bean
  public PlatformTransactionManager transactionManagerOne(DataSource dataSourceOne) {
    return new DataSourceTransactionManager(dataSourceOne);
  }

  @Bean
  public DataSourceProperties dataSourcePropertiesOne() {
    return new DataSourceProperties();
  }

  @Bean
  @Primary
  public DataSource dataSourceOne() {
    DataSourceProperties dataSourceProperties = dataSourcePropertiesOne();
    // schema init
    DatabasePopulator databasePopulator =
        new ResourceDatabasePopulator(
            new ClassPathResource("db/schema.sql"), new ClassPathResource("db/data_one.sql"));
    DataSource ds = dataSourceProperties.initializeDataSourceBuilder().build();
    DatabasePopulatorUtils.execute(databasePopulator, ds);
    log.info("data_one datasource: {}", dataSourceProperties.getUrl());
    return ds;
  }

  @Bean
  @Primary
  public JdbcTemplate jdbcTemplateOne(@Qualifier("dataSourceOne") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  @Primary
  public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource)
      throws Exception {
    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath:mapper/one/*.xml"));
    return bean.getObject();
  }

  @Bean
  @Primary
  public SqlSessionTemplate sqlSessionTemplateOne(
      @Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
