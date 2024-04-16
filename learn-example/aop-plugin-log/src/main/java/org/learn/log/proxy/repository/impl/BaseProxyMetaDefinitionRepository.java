package org.learn.log.proxy.repository.impl;

import org.learn.log.enums.OperateEventEnum;
import org.learn.log.event.ProxyMetaDefinitionChangeEvent;
import org.learn.log.proxy.model.ProxyMetaDefinition;
import org.learn.log.proxy.model.ProxyMetaDefinitionChangeEntity;
import org.learn.log.proxy.repository.ProxyMetaDefinitionRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public abstract class BaseProxyMetaDefinitionRepository
    implements ProxyMetaDefinitionRepository, ApplicationContextAware {
  protected ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void save(ProxyMetaDefinition definition) {
    if (saveProxyMetaDefinition(definition)) {
      applicationContext.publishEvent(
          new ProxyMetaDefinitionChangeEvent(
              this, new ProxyMetaDefinitionChangeEntity(OperateEventEnum.ADD, definition)));
    }
  }

  @Override
  public void delete(String proxyMetaDefinitionId) {
    if (deleteProxyMetaDefinition(proxyMetaDefinitionId)) {
      applicationContext.publishEvent(
          new ProxyMetaDefinitionChangeEvent(
              this,
              new ProxyMetaDefinitionChangeEntity(
                  OperateEventEnum.DEL,
                  ProxyMetaDefinition.builder().id(proxyMetaDefinitionId).build())));
    }
  }

  public abstract boolean saveProxyMetaDefinition(ProxyMetaDefinition definition);

  public abstract boolean deleteProxyMetaDefinition(String proxyMetaDefinitionId);
}
