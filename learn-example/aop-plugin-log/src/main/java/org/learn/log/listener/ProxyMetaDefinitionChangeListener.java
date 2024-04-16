package org.learn.log.listener;

import lombok.RequiredArgsConstructor;
import org.learn.log.event.ProxyMetaDefinitionChangeEvent;
import org.learn.log.plugin.AopPluginFactory;
import org.learn.log.proxy.model.ProxyMetaInfo;
import org.springframework.context.event.EventListener;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@RequiredArgsConstructor
public class ProxyMetaDefinitionChangeListener {
  private final AopPluginFactory aopPluginFactory;

  @EventListener
  public void listener(ProxyMetaDefinitionChangeEvent proxyMetaDefinitionChangeEvent) {
    ProxyMetaInfo proxyMetaInfo =
        aopPluginFactory.getProxyMetaInfo(proxyMetaDefinitionChangeEvent.getProxyMetaDefinition());
    switch (proxyMetaDefinitionChangeEvent.getOperateEventEnum()) {
      case ADD:
        aopPluginFactory.installPlugin(proxyMetaInfo);
        break;
      case DEL:
        aopPluginFactory.uninstallPlugin(proxyMetaInfo.getId());
        break;
    }
  }
}
