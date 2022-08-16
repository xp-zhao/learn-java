import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.indices.CreateIndex.Builder;
import io.searchbox.indices.IndicesExists;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * 功能测试
 *
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
public class JestTest {

  private JestClient jestClient;

  @Before
  public void init() {
    JestClientFactory factory = new JestClientFactory();
    factory.setHttpClientConfig(
        new HttpClientConfig.Builder("http://localhost:9200")
            .multiThreaded(true)
            .defaultMaxTotalConnectionPerRoute(2)
            .maxTotalConnection(10)
            .build());
    jestClient = factory.getObject();
  }

  @Test
  public void testDelete() throws IOException {
    JestResult jestResult = jestClient.execute(new Delete.Builder("1").index("employees").build());
    if (jestResult.isSucceeded()) {
      System.out.println("Success!");
    } else {
      System.out.println("Error: " + jestResult.getErrorMessage());
    }
  }

  @Test
  public void testIndicesExists() throws IOException {
    JestResult result = jestClient.execute(new IndicesExists.Builder("text").build());
    System.out.println(result);
  }

  @Test
  public void testCreateIndex() throws IOException {
    Map<String, Object> settings = new HashMap<>();
    settings.put("number_of_shards", 11);
    settings.put("number_of_replicas", 2);
    JestResult result = jestClient.execute(new Builder("employees").settings(settings).build());
    System.out.println(result);
  }

  @Test
  public void testIndex() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode employeeJsonNode =
        mapper
            .createObjectNode()
            .put("name", "Michael Pratt")
            .put("title", "Java Developer")
            .put("yearsOfService", 2)
            .set("skills", mapper.createArrayNode().add("java").add("spring").add("elasticsearch"));
    DocumentResult result =
        jestClient.execute(
            new Index.Builder(employeeJsonNode.toString()).index("employees").build());
    System.out.println(result);
  }
}
