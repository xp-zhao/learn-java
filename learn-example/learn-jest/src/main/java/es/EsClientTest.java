package es;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * es 原生客户端测试用例
 *
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Slf4j
public class EsClientTest {
  private RestHighLevelClient client;
  private ElasticsearchOperations esRestTemplate;

  @Before
  public void init() {
    ClientConfiguration clientConfiguration =
        ClientConfiguration.builder().connectedTo("localhost:9200").build();
    client = RestClients.create(clientConfiguration).rest();
    esRestTemplate = new ElasticsearchRestTemplate(client);
  }

  @Test
  public void testIndex() throws IOException {
    XContentBuilder builder =
        XContentFactory.jsonBuilder()
            .startObject()
            .field("fullName", "Test")
            .field("dateOfBirth", LocalDateTime.now())
            .field("age", 20)
            .endObject();
    IndexRequest indexRequest = new IndexRequest("text");
    indexRequest.source(builder);
    IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
    System.out.println(response);
  }

  @Test
  public void testSearch() throws IOException {
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.indices("text");
    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
    SearchHit[] hits = response.getHits().getHits();
    log.info(Arrays.toString(hits));
  }

  @Test
  public void testSearchBuilder() throws IOException {
    //    SearchSourceBuilder builder =
    //        new SearchSourceBuilder().postFilter(QueryBuilders.rangeQuery("age").from(5).to(10));
    SearchSourceBuilder builder = new SearchSourceBuilder();
    QueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();
    RangeQueryBuilder age = QueryBuilders.rangeQuery("authors.age").from(5).to(25);
    builder.query(age);
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
    searchRequest.source(builder);
    searchRequest.indices("text");
    log.info("DSL 语句:" + searchRequest.source().toString());
    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
    SearchHit[] hits = response.getHits().getHits();
    System.out.println("匹配结果: " + hits.length);
  }

  @Test
  public void testGet() throws IOException {
    GetRequest getRequest = new GetRequest("text");
    // AmNXpYIBXdFA9an27TX4, L2OLpYIBXdFA9an2umds
    getRequest.id("AmNXpYIBXdFA9an27TX4");
    GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
    System.out.println(response);
  }

  @Test
  public void testDelete() throws IOException {
    DeleteRequest deleteRequest = new DeleteRequest("text");
    deleteRequest.id("AmNXpYIBXdFA9an27TX4");
    DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
    System.out.println(deleteResponse);
  }
}
