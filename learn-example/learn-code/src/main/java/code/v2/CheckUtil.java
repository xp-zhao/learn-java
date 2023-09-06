package code.v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * v2版本：抽取公共方法
 *
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Slf4j
public class CheckUtil {
  private void checkUser(String detailPathOfA, String detailPathOfB) throws IOException {
    // 读取来源为 A 的用户信息
    List<UserDetail> userListOfA = readData(detailPathOfA);
    // 读取来源为 B 的用户信息
    List<UserDetail> userListOfB = readData(detailPathOfB);
    // 列表转换为 map
    Map<String, UserDetail> mapOfA = convertListToMap(userListOfA);
    Map<String, UserDetail> mapOfB = convertListToMap(userListOfB);
    // 用户信息对比
    for (Map.Entry<String, UserDetail> entry : mapOfA.entrySet()) {
      if (mapOfB.containsKey(entry.getKey())) {
        UserDetail userOfA = entry.getValue();
        UserDetail userOfB = mapOfB.get(entry.getKey());
        if (!userOfA.getAge().equals(userOfB.getAge())) {
          log.warn("age is different, key: {}", entry.getKey());
        }
        if (!userOfA.getGender().equals(userOfB.getGender())) {
          log.warn("gender is different, key: {}", entry.getKey());
        }
        if (!userOfA.getAddress().equals(userOfB.getAddress())) {
          log.warn("address is different, key: {}", entry.getKey());
        }
      }
    }
  }

  private List<UserDetail> readData(String filePath) throws IOException {
    List<UserDetail> resultList = new ArrayList<>();
    try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader1.readLine()) != null) {
        resultList.add(UserDetail.convert(line));
      }
    }
    return resultList;
  }

  public Map<String, UserDetail> convertListToMap(List<UserDetail> list) {
    return list.stream().collect(Collectors.toMap(UserDetail::getUuid, Function.identity()));
  }
}
