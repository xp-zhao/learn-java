package config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "es.repository")
public class EsConfig {
  @Bean
  RestHighLevelClient client() {
    ClientConfiguration clientConfiguration =
        ClientConfiguration.builder().connectedTo("kvm2.yxp99.com:9200").build();

    return RestClients.create(clientConfiguration).rest();
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchRestTemplate(client());
  }
}
