package code.v1;

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
 * 模拟业务流程，从不同的数据来源获取数据，然后对比数据
 *
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Slf4j
public class CheckUtil {
  private void checkUser(String detailPathOfA, String detailPathOfB) throws IOException {
    // 读取来源为 A 的用户信息
    List<UserDetail> userListOfA = new ArrayList<>();
    try (BufferedReader reader1 = new BufferedReader(new FileReader(detailPathOfA))) {
      String line;
      while ((line = reader1.readLine()) != null) {
        userListOfA.add(UserDetail.convert(line));
      }
    }
    // 读取来源为 B 的用户信息
    List<UserDetail> userListOfB = new ArrayList<>();
    try (BufferedReader reader1 = new BufferedReader(new FileReader(detailPathOfB))) {
      String line;
      while ((line = reader1.readLine()) != null) {
        userListOfB.add(UserDetail.convert(line));
      }
    }
    // 列表转换为 map
    Map<String, UserDetail> mapOfA =
        userListOfA.stream().collect(Collectors.toMap(UserDetail::getUuid, Function.identity()));
    Map<String, UserDetail> mapOfB =
        userListOfB.stream().collect(Collectors.toMap(UserDetail::getUuid, Function.identity()));
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
}
