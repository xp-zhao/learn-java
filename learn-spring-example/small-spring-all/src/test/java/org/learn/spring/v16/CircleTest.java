package org.learn.spring.v16;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一级缓存解决简单循环依赖测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Slf4j
public class CircleTest {
  private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

  public static void main(String[] args) throws Exception {
    log.info("测试结果: {}", getBean(B.class).getA());
    log.info("测试结果: {}", getBean(A.class).getB());
  }

  public static <T> T getBean(Class<T> beanClass) throws Exception {
    String beanName = beanClass.getSimpleName().toLowerCase();
    if (singletonObjects.containsKey(beanName)) {
      return (T) singletonObjects.get(beanName);
    }
    Object obj = beanClass.newInstance();
    // 对象实例化之后直接放入缓存中
    singletonObjects.put(beanName, obj);
    // 属性填充
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      Class<?> fieldType = field.getType();
      String filedName = fieldType.getSimpleName().toLowerCase();
      if (filedName.equals("int")) {
        field.set(obj, 10);
      } else {
        field.set(
            obj,
            singletonObjects.containsKey(filedName)
                ? singletonObjects.get(filedName)
                : getBean(fieldType));
      }
      field.setAccessible(false);
    }
    return (T) obj;
  }
}

class A {

  private B b;
  private int i = 1;

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }
}

class B {

  private A a;
  private int j = 1;

  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }
}
