package core.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-2-19
 **/
public class WithOutHashCode {

  public static void main(String[] args) {
    Key k1 = new Key(1);
    Key k2 = new Key(1);
    Map<Key, String> map = new HashMap<>(2);
    map.put(k1, "kkkkk");
    System.out.println(map.get(k2));
  }
}

class Key {

  private Integer id;

  public Key(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return Objects.equals(id, key.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
