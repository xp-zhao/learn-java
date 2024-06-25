package org;

import cn.hutool.json.JSONUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-6-25
 */
@Slf4j
public class BaseTest {
  @Test
  public void testCollectToMap() {
    List<Person> persons =
        Arrays.asList(new Person("John", 30), new Person("Jane", 25), new Person("John", 35));
    Map<String, Person> personMap =
        persons.stream()
            .collect(
                Collectors.toMap(
                    Person::getName, // 键值函数返回姓名,导致重复
                    Function.identity(),
                    (p1, p2) -> p1));
    log.info(JSONUtil.toJsonStr(personMap));
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class Person {
    private String name;
    private Integer age;
  }
}
