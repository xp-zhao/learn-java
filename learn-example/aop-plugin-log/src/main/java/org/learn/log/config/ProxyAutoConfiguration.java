package org.learn.log.config;

import org.learn.log.actuate.ProxyMetaDefinitionControllerEndPoint;
import org.learn.log.listener.ProxyMetaDefinitionChangeListener;
import org.learn.log.plugin.AopPluginFactory;
import org.learn.log.proxy.ProxyMetaDefinitionLocator;
import org.learn.log.proxy.repository.ProxyMetaDefinitionRepository;
import org.learn.log.proxy.repository.impl.MemoryProxyMetaDefinitionRepository;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Configuration
public class ProxyAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public MemoryProxyMetaDefinitionRepository memoryProxyMetaDefinitionRepository() {
    return new MemoryProxyMetaDefinitionRepository();
  }

  @Bean
  @ConditionalOnMissingBean
  public AopPluginFactory aopPluginFactory(
      ProxyMetaDefinitionLocator proxyMetaDefinitionLocator,
      DefaultListableBeanFactory defaultListableBeanFactory) {
    return new AopPluginFactory(proxyMetaDefinitionLocator, defaultListableBeanFactory);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProxyMetaDefinitionChangeListener proxyMetaDefinitionChangeListener(
      AopPluginFactory aopPluginFactory) {
    return new ProxyMetaDefinitionChangeListener(aopPluginFactory);
  }

  @Bean
  @ConditionalOnMissingBean
  public ProxyMetaDefinitionControllerEndPoint proxyMetaDefinitionControllerEndPoint(
      ProxyMetaDefinitionRepository proxyMetaDefinitionRepository) {
    return new ProxyMetaDefinitionControllerEndPoint(proxyMetaDefinitionRepository);
  }
}
