package code.v5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * v5版本：使用多态抽象 list 转 map 方法
 *
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Slf4j
public class CheckUtil {
  private void checkUser(String detailPathOfA, String detailPathOfB) throws IOException {
    // 读取来源为 A 的用户信息
    List<UserDetail> userListOfA = readData(detailPathOfA, UserDetail::convert);
    // 读取来源为 B 的用户信息
    List<UserDetail> userListOfB = readData(detailPathOfB, UserDetail::convert);
    // 列表转换为 map
    Map<String, UserDetail> mapOfA = convertListToMap(userListOfA);
    Map<String, UserDetail> mapOfB = convertListToMap(userListOfB);
    // 用户信息对比
    compareDiff(mapOfA, mapOfB);
  }

  private void checkAccount(String pathOfA, String pathOfB) throws IOException {
    // 读取来源为 A 的账户信息
    List<AccountDetail> listOfA = readData(pathOfA, AccountDetail::convert);
    // 读取来源为 B 的账户信息
    List<AccountDetail> listOfB = readData(pathOfB, AccountDetail::convert);
    // 列表转换为 map
    Map<String, AccountDetail> mapOfA = convertListToMap(listOfA);
    Map<String, AccountDetail> mapOfB = convertListToMap(listOfB);
    // 账户信息对比
    compareDiff(mapOfA, mapOfB);
  }

  private <T> List<T> readData(String filePath, Function<String, T> converter) throws IOException {
    List<T> resultList = new ArrayList<>();
    try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader1.readLine()) != null) {
        resultList.add(converter.apply(line));
      }
    }
    return resultList;
  }

  private <T extends IKey> Map<String, T> convertListToMap(List<T> list) {
    return list.stream().collect(Collectors.toMap(IKey::getKey, Function.identity()));
  }

  private <T> void compareDiff(Map<String, T> mapA, Map<String, T> mapB) {
    for (Map.Entry<String, T> entry : mapA.entrySet()) {
      if (mapB.containsKey(entry.getKey())) {
        T v1 = entry.getValue();
        T v2 = mapB.get(entry.getKey());
        List<String> resultList = compareObjects(v1, v2);
        for (String r : resultList) {
          log.warn("{} is different, key: {}", r, entry.getKey());
        }
      }
    }
  }

  private List<String> compareObjects(Object obj1, Object obj2) {
    List<String> list = new ArrayList<>();
    Class<?> clazz = obj1.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      String fieldName = field.getName();
      field.setAccessible(true);
      try {
        Object v1 = field.get(obj1);
        Object v2 = field.get(obj2);
        if ((v1 == null && v2 != null) || (v1 != null && !v1.equals(v2))) {
          list.add(fieldName);
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
}
