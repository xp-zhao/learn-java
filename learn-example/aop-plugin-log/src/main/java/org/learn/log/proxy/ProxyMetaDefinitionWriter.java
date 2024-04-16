package org.learn.log.proxy;

import org.learn.log.proxy.model.ProxyMetaDefinition;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public interface ProxyMetaDefinitionWriter {
  void save(ProxyMetaDefinition definition);

  void delete(String proxyMetaDefinitionId);
}
