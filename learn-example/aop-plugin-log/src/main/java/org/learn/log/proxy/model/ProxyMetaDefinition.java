package org.learn.log.proxy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProxyMetaDefinition {
  private String id;

  private String proxyUrl;

  private String proxyClassName;

  private String pointcut;
}
