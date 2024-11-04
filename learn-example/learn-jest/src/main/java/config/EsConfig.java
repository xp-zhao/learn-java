package config;

import common.Constants;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Slf4j
@Configuration
public class EsConfig
    implements FactoryBean<RestHighLevelClient>, InitializingBean, DisposableBean {

  private static final String SCHEME = "http";

  private RestHighLevelClient restHighLevelClient;

  @Override
  public void destroy() throws Exception {
    try {
      if (null != restHighLevelClient) {
        restHighLevelClient.close();
      }
    } catch (final Exception e) {
      log.error("Error closing ElasticSearch client: ", e);
    }
  }

  @Override
  public RestHighLevelClient getObject() throws Exception {
    return restHighLevelClient;
  }

  @Override
  public Class<?> getObjectType() {
    return RestHighLevelClient.class;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    restHighLevelClient = buildClient();
  }

  private RestHighLevelClient buildClient() {
    try {
      String[] hosts = Constants.ES_NODE.split(",");
      List<HttpHost> httpHosts = new ArrayList<>(hosts.length);
      for (String node : hosts) {
        HttpHost host =
            new HttpHost(node.split(":")[0], Integer.parseInt(node.split(":")[1]), SCHEME);
        httpHosts.add(host);
      }
      restHighLevelClient =
          new RestHighLevelClient(RestClient.builder(httpHosts.toArray(new HttpHost[0])));
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return restHighLevelClient;
  }
}
