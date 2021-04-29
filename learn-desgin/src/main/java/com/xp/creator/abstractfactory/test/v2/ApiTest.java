package v2;

import com.xp.creator.abstractfactory.v2.CacheService;
import com.xp.creator.abstractfactory.v2.factory.JDKInvocationHandler;
import com.xp.creator.abstractfactory.v2.factory.impl.EGMCacheAdapter;
import com.xp.creator.abstractfactory.v2.factory.impl.IIRCacheAdapter;
import com.xp.creator.abstractfactory.v2.impl.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description: 测试
 * @Date 2021-4-28
 **/
@Slf4j
public class ApiTest {

  @Test
  public void testCacheService() throws Exception {
    JDKInvocationHandler handler = new JDKInvocationHandler(new EGMCacheAdapter());
    CacheService proxy_EGM = handler.getProxy(CacheServiceImpl.class);
    proxy_EGM.set("user_name_01", "小傅哥");
    String val01 = proxy_EGM.get("user_name_01");
    System.out.println("测试结果：" + val01);

    handler.setCacheAdapter(new IIRCacheAdapter());
    CacheService proxy_IIR = handler.getProxy(CacheServiceImpl.class);
    proxy_IIR.set("user_name_01", "小傅哥");
    String val02 = proxy_IIR.get("user_name_01");
    System.out.println("测试结果：" + val02);

  }
}
