package es;

import config.EsConfig;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaoxiaoping
 * @date 2024-11-4
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EsConfig.class})
public class IndexTest {
  @Autowired private EsConfig esConfig;
  private static final String INDEX_NAME = "author";

  @Test
  public void testCreateIndex() throws Exception {
    RestHighLevelClient client = esConfig.getObject();
    XContentBuilder builder = XContentFactory.jsonBuilder();
    builder.startObject();
    {
      builder.startObject("properties");
      {
        builder.startObject("name");
        {
          builder.field("type", "text");
        }
        builder.endObject();
        builder.startObject("age");
        {
          builder.field("type", "integer");
        }
        builder.endObject();
      }
      builder.endObject();
    }
    builder.endObject();
    CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
    request.mapping(builder);
    CreateIndexResponse resp = client.indices().create(request, RequestOptions.DEFAULT);
    log.info("{}", resp);
  }

  @Test
  public void testExistIndex() throws Exception {
    GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
    // 参数
    // 从主节点返回本地索引信息状态
    request.local(false);
    // 以适合人类的格式返回
    request.humanReadable(true);
    // 是否返回每个索引的所有默认配置
    request.includeDefaults(false);
    RestHighLevelClient client = esConfig.getObject();
    boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
    log.info("exists:{}", exists);
  }
}
