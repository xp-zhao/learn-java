package java.org.learn.spring.core.io;

/**
 * 获取资源接口
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface ResourceLoader {
  /** Pseudo URL prefix for loading from the class path: "classpath:" */
  String CLASSPATH_URL_PREFIX = "classpath:";

  /**
   * 获得资源
   *
   * @param location 位置
   * @return {@link Resource}
   */
  Resource getResource(String location);
}
