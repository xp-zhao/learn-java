package org.learn.log.utils;

import cn.hutool.core.util.StrUtil;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.SneakyThrows;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
public class ClassUtil {
  private ClassUtil() {}

  private static Map<String, Class> targetClzMap = new ConcurrentHashMap<>();

  private static Map<String, Object> targetObjMap = new ConcurrentHashMap<>();

  @SneakyThrows
  public static Class getClz(String targetClassUrl, String className) {
    String key = targetClassUrl + StrUtil.UNDERLINE + className;
    if (StrUtil.isBlank(targetClassUrl)) {
      Class<?> clazz = Class.forName(className);
      targetClzMap.put(key, clazz);
      return clazz;
    }
    if (targetClzMap.containsKey(key)) {
      return targetClzMap.get(key);
    }
    URL url = new URL(targetClassUrl);
    URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {url});
    Class clz = urlClassLoader.loadClass(className);
    targetClzMap.put(key, clz);
    return clz;
  }

  @SneakyThrows
  public static Object getObj(String targetClassUrl, String className) {
    String key = targetClassUrl + StrUtil.UNDERLINE + className;
    if (targetObjMap.containsKey(key)) {
      return targetObjMap.get(key);
    }
    Class targetClz = getClz(targetClassUrl, className);
    Object obj = targetClz.getConstructor().newInstance();
    targetObjMap.put(key, obj);
    return obj;
  }
}
