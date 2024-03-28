package mockito.redis;

import com.github.fppt.jedismock.RedisServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import redis.clients.jedis.Jedis;

import java.io.IOException;

import static org.mockito.Mockito.when;

/**
 * @author zhaoxiaoping
 * @date 2024-3-28
 */
@Slf4j
public class RedisServiceTest {
  private Jedis jedis;
  private RedisServer redisServer;

  @Before
  public void setUp() throws Exception {
    // 启动 Redis 服务器的嵌入式模拟
    redisServer = RedisServer.newRedisServer();
    redisServer.start();

    // 创建 Jedis 客户端并连接到模拟的 Redis 服务器
    jedis = new Jedis("localhost", redisServer.getBindPort());
  }

  @After
  public void tearDown() throws IOException {
    // 停止 Redis 服务器的嵌入式模拟
    redisServer.stop();
  }

  @Test
  public void testRedisOperations() {
    // 使用 Mockito 对 Jedis 客户端进行 mock
    Jedis mockJedis = Mockito.spy(jedis);

    // 配置 mock 行为
    when(mockJedis.get("key")).thenReturn("value");
    when(mockJedis.set("key", "value")).thenReturn("OK");

    // 测试 Redis 操作
    Assert.assertEquals("value", mockJedis.get("key"));
    Assert.assertEquals("OK", mockJedis.set("key", "value"));
  }
}
