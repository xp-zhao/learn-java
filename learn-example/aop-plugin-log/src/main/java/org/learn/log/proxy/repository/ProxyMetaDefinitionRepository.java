package org.learn.log.proxy.repository;

import org.learn.log.proxy.ProxyMetaDefinitionLocator;
import org.learn.log.proxy.ProxyMetaDefinitionWriter;
import org.learn.log.proxy.model.ProxyMetaDefinition;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public interface ProxyMetaDefinitionRepository
    extends ProxyMetaDefinitionLocator, ProxyMetaDefinitionWriter {
  ProxyMetaDefinition getProxyMetaDefinition(String proxyMetaDefinitionId);
}
