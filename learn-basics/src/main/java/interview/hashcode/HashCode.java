package interview.hashcode;

import cn.hutool.core.collection.CollUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** @author zhaoxiaoping @Description: @Date 2021-9-26 */
public class HashCode {
  public static Integer hashCode(String str, Integer multiplier) {
    int hash = 0;
    for (int i = 0; i < str.length(); i++) {
      hash = multiplier * hash + str.charAt(i);
    }
    return hash;
  }

  public static List<RateInfo> collisionRateList(Set<String> strSet, Integer... multipliers) {
    List<RateInfo> rateList = new ArrayList<>();
    for (Integer multiplier : multipliers) {
      List<Integer> hashCodeList =
          strSet
              .parallelStream()
              .map(str -> hashCode(str, multiplier))
              .collect(Collectors.toList());
      rateList.add(hashCollisionRate(multiplier, hashCodeList));
    }
    return rateList;
  }

  private static RateInfo hashCollisionRate(Integer multiplier, List<Integer> hashCodeList) {
    Integer maxHash = CollUtil.max(hashCodeList);
    Integer minHash = CollUtil.min(hashCodeList);
    int collisionCount = (int) (hashCodeList.size() - hashCodeList.stream().distinct().count());
    double collisionRate = (collisionCount * 1.0) / hashCodeList.size();
    return new RateInfo(maxHash, minHash, multiplier, collisionCount, collisionRate);
  }
}
