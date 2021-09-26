package interview.hashmap;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/** @author zhaoxiaoping @Description: @Date 2021-9-26 */
public class ApiTest {
  @Test
  public void test01() {
    // 初始化一组字符串
    List<String> list = new ArrayList<>();
    list.add("jlkk");
    list.add("lopi");
    list.add("asdc");
    list.add("e4we");
    list.add("alpo");
    list.add("yhjk");
    list.add("plop");
    // 定义要存放的数组
    String[] tab = new String[8];
    // 循环存放
    for (String key : list) {
      int idx = key.hashCode() & (tab.length - 1); // 计算索引位置
      System.out.println(String.format("key值=%s Idx=%d", key, idx));
      if (null == tab[idx]) {
        tab[idx] = key;
        continue;
      }
      tab[idx] = tab[idx] + "->" + key;
    }
    // 输出测试结果
    System.out.println("测试结果：" + JSON.toJSONString(tab));
  }

  @Test
  public void test02() {
    List<String> list = new ArrayList<>();
    list.add("jlkk");
    list.add("lopi");
    list.add("jmdw");
    list.add("e4we");
    list.add("io98");
    list.add("nmhg");
    list.add("vfg6");
    list.add("gfrt");
    list.add("alpo");
    list.add("vfbh");
    list.add("bnhj");
    list.add("zuio");
    list.add("iu8e");
    list.add("yhjk");
    list.add("plop");
    list.add("dd0p");

    for (String key : list) {
      int hash = key.hashCode() ^ (key.hashCode() >>> 16);
      System.out.println(
          "字符串: "
              + key
              + "\tIdx(16): "
              + ((32 - 1) & hash)
              + "\tBit 值:"
              + Integer.toBinaryString(hash)
              + "-"
              + Integer.toBinaryString(hash & 32)
              + " \tIdx(32): "
              + Integer.toBinaryString(key.hashCode())
              + " "
              + Integer.toBinaryString(hash)
              + " "
              + Integer.toBinaryString((64 - 1) & hash));
    }
  }
  
  @Test
  public void test03(){
    Map<String, String> map = new HashMap<String, String>();
    map.put("a", "a");
    map.put("a", "b");
    for (Entry<String, String> entry : map.entrySet()) {
    }
  }
}
