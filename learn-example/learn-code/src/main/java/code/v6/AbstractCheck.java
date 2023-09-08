package code.v6;

import cn.hutool.core.lang.Pair;
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
 * v6版本：使用抽象类，定义数据对比流程
 *
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Slf4j
public abstract class AbstractCheck<T extends IKey> {
  public void check(String filePathA, String filePathB) throws IOException {
    // 从文件中读取数据
    Pair<List<T>, List<T>> listPair = readDataFromFile(filePathA, filePathB, this::convert);
    List<T> listOfA = listPair.getKey();
    List<T> listOfB = listPair.getValue();
    // 数据转换
    Pair<Map<String, T>, Map<String, T>> mapPair = convertListToMap(listOfA, listOfB);
    Map<String, T> mapA = mapPair.getKey();
    Map<String, T> mapB = mapPair.getValue();
    // 数据对比
    compareDiff(mapA, mapB);
  }

  private Pair<List<T>, List<T>> readDataFromFile(
      String filePathA, String filePathB, Function<String, T> converter) throws IOException {
    List<T> listOfA = readDataFromFile(filePathA, converter);
    List<T> listOfB = readDataFromFile(filePathB, converter);
    return new Pair<>(listOfA, listOfB);
  }

  private <T> List<T> readDataFromFile(String filePath, Function<String, T> converter)
      throws IOException {
    List<T> resultList = new ArrayList<>();
    try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader1.readLine()) != null) {
        resultList.add(converter.apply(line));
      }
    }
    return resultList;
  }

  private Pair<Map<String, T>, Map<String, T>> convertListToMap(List<T> listA, List<T> listB) {
    return new Pair<>(convertListToMap(listA), convertListToMap(listB));
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

  protected abstract T convert(String line);
}
