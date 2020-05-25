package hash;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoxiaoping
 * @Description: HashMap 测试
 * @Date 2020/5/19
 **/
public class HashMapDemo {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    Map<String, String> map = new HashMap<>(9);
    map.put("xp-key", "xp-value");

    Class<?> mapType = map.getClass();
    Method capacity = mapType.getDeclaredMethod("capacity");
    capacity.setAccessible(true);
    System.out.println("capacity : " + capacity.invoke(map));

    Field size = mapType.getDeclaredField("size");
    size.setAccessible(true);
    System.out.println("size : " + size.get(map));
  }
}
