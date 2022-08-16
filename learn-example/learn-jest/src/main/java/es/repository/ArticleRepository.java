package es.repository;

import model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
  /**
   * 找到作者名字
   *
   * @param name 名字
   * @param pageable 可分页
   * @return {@code Page<Article>}
   */
  Page<Article> findByAuthorsName(String name, Pageable pageable);
}
