package v1;

import com.xp.creator.abstractfactory.v1.CacheService;
import com.xp.creator.abstractfactory.v1.impl.CacheServiceImpl;
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
  public void testCacheService() {

    CacheService cacheService = new CacheServiceImpl();

    cacheService.set("user_name_01", "小傅哥", 1);
    String val01 = cacheService.get("user_name_01", 1);
    log.info("测试结果：{}", val01);

  }
}
