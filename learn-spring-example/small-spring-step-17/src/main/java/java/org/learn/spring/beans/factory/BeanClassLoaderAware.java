package java.org.learn.spring.beans.factory;

/**
 * 所属 ClassLoader 感知接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface BeanClassLoaderAware extends Aware {
  /**
   * 设置bean类加载器
   *
   * @param classLoader 类加载器
   */
  void setBeanClassLoader(ClassLoader classLoader);
}
