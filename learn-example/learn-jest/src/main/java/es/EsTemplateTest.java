package es;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;
import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

import com.google.common.collect.Lists;
import config.EsConfig;
import es.repository.ArticleRepository;
import java.util.Collections;
import java.util.List;
import model.Article;
import model.Author;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EsConfig.class)
public class EsTemplateTest {
  @Autowired private ElasticsearchRestTemplate elasticsearchTemplate;

  @Autowired private ArticleRepository articleRepository;

  @Test
  public void testSave() {
    Author author = new Author();
    author.setName("xp");
    author.setAge(20);
    Article article = new Article();
    article.setId("ppp");
    article.setTitle("保存测试");
    article.setRandomText("ppp");
    article.setAuthors(Lists.newArrayList());
    article.setAuthors(Collections.singletonList(author));
    article = articleRepository.save(article);
    System.out.println(article);
  }

  @Test
  public void testQuery() {
    Page<Article> result = articleRepository.findByAuthorsName("xp", PageRequest.of(0, 10));
    System.out.println(result);
  }

  @Test
  public void testCustomQuery() {
    //    Query searchQuery =
    //        new
    // NativeSearchQueryBuilder().withFilter(rangeQuery("authors.age").from(5).to(15)).build();
    NestedQueryBuilder queryBuilder =
        nestedQuery("authors", rangeQuery("authors.age").from(5).to(25), ScoreMode.None);
    NativeSearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
    SearchHits<Article> hits = elasticsearchTemplate.search(searchQuery, Article.class);
    System.out.println(hits.getTotalHits());
  }

  @Test
  public void testUpdate() {
    Query searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("id", "xxx")).build();
    SearchHits<Article> articles =
        elasticsearchTemplate.search(searchQuery, Article.class, IndexCoordinates.of("text"));
    Article article = articles.getSearchHit(0).getContent();
    List<Author> authors = article.getAuthors();
    authors.forEach(item -> item.setAge(12));
    elasticsearchTemplate.save(article);
    System.out.println(article);
  }
}
