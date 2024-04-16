package org.learn.log.event;

import cn.hutool.core.util.ObjectUtil;
import org.learn.log.enums.OperateEventEnum;
import org.learn.log.proxy.model.ProxyMetaDefinition;
import org.learn.log.proxy.model.ProxyMetaDefinitionChangeEntity;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.ObjectUtils;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public class ProxyMetaDefinitionChangeEvent extends ApplicationEvent {
  private final ProxyMetaDefinitionChangeEntity proxyMetaDefinitionChangeEntity;

  public ProxyMetaDefinitionChangeEvent(
      Object source, ProxyMetaDefinitionChangeEntity proxyMetaDefinitionChangeEntity) {
    super(source);
    this.proxyMetaDefinitionChangeEntity = proxyMetaDefinitionChangeEntity;
  }

  public OperateEventEnum getOperateEventEnum() {
    if (ObjectUtil.isNull(proxyMetaDefinitionChangeEntity)) {
      return OperateEventEnum.UNKNOWN;
    }
    return proxyMetaDefinitionChangeEntity.getOperateEventEnum();
  }

  public ProxyMetaDefinition getProxyMetaDefinition() {
    if (ObjectUtils.isEmpty(proxyMetaDefinitionChangeEntity)) {
      return null;
    }
    return proxyMetaDefinitionChangeEntity.getDefinition();
  }
}
