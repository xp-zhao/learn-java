package es;

import common.EsIndexEnum;
import config.EsConfig;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    CreateIndexRequest request = new CreateIndexRequest(EsIndexEnum.AUTHOR.getIndexName());
    request.mapping(builder);
    CreateIndexResponse resp = client.indices().create(request, RequestOptions.DEFAULT);
    log.info("{}", resp);
  }

  @Test
  public void testCreateArticleIndex() throws Exception {
    RestHighLevelClient client = esConfig.getObject();
    Resource resource = new ClassPathResource("article_mapping.json");
    String jsonString = new String(Files.readAllBytes(Paths.get(resource.getURI())));
    CreateIndexRequest request = new CreateIndexRequest(EsIndexEnum.ARTICLE.getIndexName());
    request.mapping(jsonString, XContentType.JSON);
    CreateIndexResponse resp = client.indices().create(request, RequestOptions.DEFAULT);
    log.info("{}", resp);
  }

  @Test
  public void testExistIndex() throws Exception {
    GetIndexRequest request = new GetIndexRequest(EsIndexEnum.AUTHOR.getIndexName());
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

  @Test
  public void testGetMappings() throws Exception {
    GetMappingsRequest request = new GetMappingsRequest();
    request.indices(EsIndexEnum.QUESTION.getIndexName());
    RestHighLevelClient client = esConfig.getObject();
    GetMappingsResponse resp = client.indices().getMapping(request, RequestOptions.DEFAULT);
    log.info("{}", resp.mappings());
  }
}
