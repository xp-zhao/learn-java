package org.learn.log.proxy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.learn.log.enums.OperateEventEnum;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProxyMetaDefinitionChangeEntity {
  private OperateEventEnum operateEventEnum;

  private ProxyMetaDefinition definition;
}
