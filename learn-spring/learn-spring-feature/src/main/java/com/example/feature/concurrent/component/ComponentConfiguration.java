package com.example.feature.concurrent.component;

import com.example.feature.concurrent.ProcessorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
public class ComponentConfiguration {
  @Autowired private ConfigProperties configProperties;

  @Bean
  public ProducerAndConsumerComponent registerBean() {
    return new ProducerAndConsumerComponent(
        configProperties.getThreadNum(),
        configProperties.getQueueSizeLimit(),
        configProperties.getPeriod(),
        configProperties.getCapacity(),
        new ProcessorImpl());
  }
}
