package org.learn.log.proxy.repository.impl;

import static java.util.Collections.synchronizedMap;

import cn.hutool.core.util.StrUtil;
import java.util.*;
import org.learn.log.proxy.model.ProxyMetaDefinition;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public class MemoryProxyMetaDefinitionRepository extends BaseProxyMetaDefinitionRepository {
  private final Map<String, ProxyMetaDefinition> proxyMetaDefinitionMap =
      synchronizedMap(new LinkedHashMap());

  @Override
  public boolean saveProxyMetaDefinition(ProxyMetaDefinition definition) {
    if (StrUtil.isBlank(definition.getId())) {
      throw new IllegalArgumentException("Id can not be empty");
    }
    proxyMetaDefinitionMap.put(definition.getId(), definition);
    return true;
  }

  @Override
  public boolean deleteProxyMetaDefinition(String proxyMetaDefinitionId) {
    if (proxyMetaDefinitionMap.containsKey(proxyMetaDefinitionId)) {
      proxyMetaDefinitionMap.remove(proxyMetaDefinitionId);
    } else {
      throw new NoSuchElementException("ProxyMetaDefinition not found: " + proxyMetaDefinitionId);
    }
    return true;
  }

  @Override
  public ProxyMetaDefinition getProxyMetaDefinition(String proxyMetaDefinitionId) {
    return proxyMetaDefinitionMap.get(proxyMetaDefinitionId);
  }

  @Override
  public List<ProxyMetaDefinition> getProxyMetaDefinitions() {
    return new ArrayList<>(proxyMetaDefinitionMap.values());
  }
}
