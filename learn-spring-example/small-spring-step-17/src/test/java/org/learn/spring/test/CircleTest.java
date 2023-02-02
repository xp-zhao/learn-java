package org.learn.spring.test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 循环依赖测试
 *
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
public class CircleTest {
  private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

  public static void main(String[] args) throws Exception {
    System.out.println(getBean(B.class).getA());
    System.out.println(getBean(A.class).getB());
  }

  private static <T> T getBean(Class<T> beanClass) throws Exception {
    String beanName = beanClass.getSimpleName().toLowerCase();
    if (singletonObjects.containsKey(beanName)) {
      return (T) singletonObjects.get(beanName);
    }
    // 实例化对象入缓存
    Object obj = beanClass.newInstance();
    singletonObjects.put(beanName, obj);
    // 属性填充补全对象
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      Class<?> fieldClass = field.getType();
      String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
      if (fieldBeanName.equals("int")) {
        field.set(obj, 10);
      } else {
        field.set(
            obj,
            singletonObjects.containsKey(fieldBeanName)
                ? singletonObjects.get(fieldBeanName)
                : getBean(fieldClass));
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
