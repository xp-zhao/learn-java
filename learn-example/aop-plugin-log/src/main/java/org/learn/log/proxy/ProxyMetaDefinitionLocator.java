package org.learn.log.proxy;

import java.util.List;
import org.learn.log.proxy.model.ProxyMetaDefinition;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@FunctionalInterface
public interface ProxyMetaDefinitionLocator {
  List<ProxyMetaDefinition> getProxyMetaDefinitions();
}
