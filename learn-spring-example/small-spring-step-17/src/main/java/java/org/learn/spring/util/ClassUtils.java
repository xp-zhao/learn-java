package java.org.learn.spring.util;

/**
 * class 工具类
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public class ClassUtils {
  /**
   * 获取默认类加载器
   *
   * @return {@link ClassLoader}
   */
  public static ClassLoader getDefaultClassLoader() {
    ClassLoader cl = null;
    try {
      cl = Thread.currentThread().getContextClassLoader();
    } catch (Throwable ex) {
      // Cannot access thread context ClassLoader - falling back to system class loader...
    }
    if (cl == null) {
      // No thread context class loader -> use class loader of this class.
      cl = ClassUtils.class.getClassLoader();
    }
    return cl;
  }

  /**
   * Check whether the specified class is a CGLIB-generated class.
   *
   * @param clazz the class to check
   */
  public static boolean isCglibProxyClass(Class<?> clazz) {
    return (clazz != null && isCglibProxyClassName(clazz.getName()));
  }

  /**
   * Check whether the specified class name is a CGLIB-generated class.
   *
   * @param className the class name to check
   */
  public static boolean isCglibProxyClassName(String className) {
    return (className != null && className.contains("$$"));
  }
}
