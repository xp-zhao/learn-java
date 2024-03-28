package mockito.zookeeper;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-3-28
 */
@Slf4j
public class ZookeeperTest {
  private TestingServer testingCluster;
  private CuratorFramework framework;

  @Before
  public void init() throws Exception {
    testingCluster = new TestingServer(2181, true);
    testingCluster.start();

    framework =
        CuratorFrameworkFactory.newClient("127.0.0.1", new ExponentialBackoffRetry(1000, 3));
    framework.start();
  }

  @After
  public void close() throws IOException {
    // 关闭 Curator 客户端和嵌入式 Zookeeper 服务器
    framework.close();
    testingCluster.close();
  }

  @Test
  public void testZookeeperOperations() throws Exception {
    // 创建一个 Zookeeper 节点
    framework.create().forPath("/test", "data".getBytes());

    // 获取节点数据
    byte[] data = framework.getData().forPath("/test");
    Assert.assertEquals("data", new String(data));
  }
}
