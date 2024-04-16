package org.learn.log.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.log.plugin.AopPluginFactory;
import org.learn.log.proxy.model.ProxyMetaInfo;
import org.learn.log.service.AopLogService;
import org.learn.log.utils.AopUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AopLogTest {
  @Resource private AopLogService aopLogService;
  @Resource private AopPluginFactory aopPluginFactory;

  @Test
  public void testProxy() {
    aopLogService.sayHi("hello");
    ProxyMetaInfo proxyMetaInfo =
        ProxyMetaInfo.builder()
            .proxyClassName("org.learn.log.interceptor.LogMethodInterceptor")
            .pointcut("execution (* org.learn.log.service.AopLogService.*(..))")
            .target(aopLogService)
            .build();
    AopLogService proxy = AopUtil.getProxy(proxyMetaInfo);
    proxy.sayHi("proxy");
  }

  @Test
  public void testLogPlugin() {
    aopLogService.sayHi("hello");
    ProxyMetaInfo proxyMetaInfo =
        ProxyMetaInfo.builder()
            .proxyClassName("org.learn.log.interceptor.LogMethodInterceptor")
            .pointcut("execution (* org.learn.log.service.AopLogService.*(..))")
            .target(aopLogService)
            .id("aopLogService")
            .build();
    aopPluginFactory.installPlugin(proxyMetaInfo);
    aopLogService.sayHi("install");
    //    aopPluginFactory.uninstallPlugin("aopLogService");
    //    aopLogService.sayHi("uninstall");
  }
}
