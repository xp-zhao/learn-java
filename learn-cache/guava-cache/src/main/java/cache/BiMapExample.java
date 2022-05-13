package cache;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 双向 Map 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
public class BiMapExample {
  public static void main(String[] args) {
    HashBiMap<String, String> biMap = HashBiMap.create();
    biMap.put("Hydra", "Programmer");
    biMap.put("Tony", "IronMan");
    // 不能设置重复的 value
    //    biMap.put("Stark","IronMan");
    // 强制替换的原来的 key
    biMap.forcePut("Stark", "IronMan");
    biMap.put("Thanos", "Titan");

    // 使用key获取value
    System.out.println(biMap.get("Tony"));

    BiMap<String, String> inverse = biMap.inverse();
    // 使用value获取key
    System.out.println(inverse.get("Titan"));
    System.out.println("原值: " + biMap);
    inverse.put("IronMan", "Stark");
    System.out.println("反转并修改后的值: " + biMap);
  }
}
