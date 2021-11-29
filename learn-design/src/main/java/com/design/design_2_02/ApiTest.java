package com.design.design_2_02;

import com.design.design_2_02.factory.JDKProxy;
import com.design.design_2_02.factory.impl.EGMCacheAdapter;
import com.design.design_2_02.factory.impl.IIRCacheAdapter;
import com.design.design_2_02.impl.CacheServiceImpl;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class ApiTest {
  @Test
  public void testCacheService() {
    CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
    proxy_EGM.set("name", "xp");
    CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
    proxy_IIR.set("name", "xp1");
    System.out.println("测试结果: " + proxy_EGM.get("name"));
    System.out.println("测试结果: " + proxy_IIR.get("name"));
  }
}
