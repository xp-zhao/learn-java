package org.learn.log.plugin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.learn.log.proxy.ProxyMetaDefinitionLocator;
import org.learn.log.proxy.model.ProxyMetaDefinition;
import org.learn.log.proxy.model.ProxyMetaInfo;
import org.learn.log.utils.AopUtil;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.StringUtils;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@RequiredArgsConstructor
public class AopPluginFactory implements SmartInitializingSingleton {
  private final ProxyMetaDefinitionLocator proxyMetaDefinitionLocator;
  private final DefaultListableBeanFactory defaultListableBeanFactory;

  public void installPlugin(ProxyMetaInfo proxyMetaInfo) {
    if (StrUtil.isBlank(proxyMetaInfo.getId())) {
      proxyMetaInfo.setId(
          proxyMetaInfo.getProxyUrl() + StrUtil.UNDERLINE + proxyMetaInfo.getProxyClassName());
    }
    AopUtil.registerProxy(defaultListableBeanFactory, proxyMetaInfo);
  }

  public void uninstallPlugin(String id) {
    String beanName = AopUtil.PROXY_PLUGIN_PREFIX + id;
    if (defaultListableBeanFactory.containsBean(beanName)) {
      AopUtil.destoryProxy(defaultListableBeanFactory, id);
    } else {
      throw new NoSuchElementException("Plugin not found: " + id);
    }
  }

  public void initPlugin() {
    List<ProxyMetaDefinition> proxyMetaDefinitions =
        proxyMetaDefinitionLocator.getProxyMetaDefinitions();
    if (CollUtil.isEmpty(proxyMetaDefinitions)) {
      return;
    }
    for (ProxyMetaDefinition proxyMetaDefinition : proxyMetaDefinitions) {
      ProxyMetaInfo proxyMetaInfo = getProxyMetaInfo(proxyMetaDefinition);
      AopUtil.registerProxy(defaultListableBeanFactory, proxyMetaInfo);
    }
  }

  public ProxyMetaInfo getProxyMetaInfo(ProxyMetaDefinition proxyMetaDefinition) {
    validateProxyMetaDefinition(proxyMetaDefinition);
    String id =
        StringUtils.hasText(proxyMetaDefinition.getId())
            ? proxyMetaDefinition.getId()
            : proxyMetaDefinition.getProxyUrl()
                + StrUtil.UNDERLINE
                + proxyMetaDefinition.getProxyClassName();
    return ProxyMetaInfo.builder()
        .id(id)
        .proxyUrl(proxyMetaDefinition.getProxyUrl())
        .proxyClassName(proxyMetaDefinition.getProxyClassName())
        .pointcut(proxyMetaDefinition.getPointcut())
        .build();
  }

  private void validateProxyMetaDefinition(ProxyMetaDefinition proxyMetaDefinition) {
    if (ObjectUtil.isNull(proxyMetaDefinition)) {
      throw new IllegalArgumentException("ProxyMetaDefinition can not be empty");
    }
  }

  @Override
  public void afterSingletonsInstantiated() {
    initPlugin();
  }
}
