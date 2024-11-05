package common;

/**
 * 索引枚举
 *
 * @author zhaoxiaoping
 * @date 2024-11-4
 */
public enum EsIndexEnum {
  QUESTION("question"),
  AUTHOR("author"),
  ARTICLE("article");

  private String indexName;

  EsIndexEnum(String indexName) {
    this.indexName = indexName;
  }

  public String getIndexName() {
    return indexName;
  }
}
