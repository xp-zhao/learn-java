package es;

import cn.hutool.http.HttpUtil;
import common.Constants;
import common.EsIndexEnum;
import common.PageResponse;
import config.EsConfig;
import lombok.extern.slf4j.Slf4j;
import model.Author;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.rescore.QueryRescorerBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.EsUtil;

/**
 * @author zhaoxiaoping
 * @date 2024-11-4
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EsConfig.class, EsUtil.class})
public class ApiTest {

  @Autowired private EsUtil esUtil;

  @Test
  public void testCatIndices() {
    String s = HttpUtil.get(Constants.ES_NODE + "/_cat/indices");
    log.info("{}", s);
  }

  @Test
  public void testAddDoc() {
    Author author = new Author();
    author.setName("xp");
    author.setAge(18);
    Boolean result = esUtil.addOrUptDocToEs(author, EsIndexEnum.AUTHOR.getIndexName());
    log.info("{}", result);
  }

  @Test
  public void testSearch() {
    int pageNum = 1;
    int pageSize = 10;
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

    // 根据 name, age 进行 match query
    MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("xp", "name", "age");
    searchSourceBuilder.query(multiMatchQuery);

    // 使用 reScore 利用 match_phrase 重新算分排
    MultiMatchQueryBuilder reScoreQuery =
        QueryBuilders.multiMatchQuery("xp", "name", "age").type(MultiMatchQueryBuilder.Type.PHRASE);
    QueryRescorerBuilder queryRescorerBuilder = new QueryRescorerBuilder(reScoreQuery);
    //    searchSourceBuilder.addRescorer(queryRescorerBuilder);

    // 分页
    int from = pageSize * (pageNum - 1);
    searchSourceBuilder.size(pageSize).from(from);
    PageResponse<Author> resp =
        esUtil.search(
            EsIndexEnum.AUTHOR.getIndexName(),
            searchSourceBuilder,
            Author.class,
            pageNum,
            pageSize);
    log.info("{}", resp.getData());
  }
  
  @Test
  public void testSearchAllDoc(){
    esUtil.searchAllDoc(EsIndexEnum.AUTHOR.getIndexName());
  }
}
