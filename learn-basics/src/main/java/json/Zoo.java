package json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 动物园
 * @Date 2020/5/6
 **/
@Data
public class Zoo {

  private String name;
  private String city;
  private List<Animal> animals;

  public static void main(String[] args) {
    Zoo zoo = new Zoo();
    Lion lion = Lion.builder()
        .name("lion")
        .age(2)
        .lionFeature("lion feature")
        .build();
    Tiger tiger = Tiger.builder()
        .name("tiger")
        .age(3)
        .tigerFeature("tiger feature")
        .build();
    List<Animal> animals = new ArrayList<>();
    animals.add(lion);
    animals.add(tiger);
    zoo.setAnimals(animals);
    zoo.setCity("北京");
    zoo.setName("北京天上地下动物园");

    String str = JSON.toJSONString(zoo);
    System.out.println(zoo);
    System.out.println(str);
    ObjectMapper mapper = new ObjectMapper();
    Zoo zoo1 = null;
    try {
      zoo1 = mapper.readValue(str, Zoo.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println(zoo1);
  }
}
