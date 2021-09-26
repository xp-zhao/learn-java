package interview.hashmap;

/** @author zhaoxiaoping @Description: 扰动函数测试 @Date 2021-9-26 */
public class Disturb {
  public static int disturbHashIdx(String key, int size) {
    return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
  }

  public static int hashIdx(String key, int size) {
    return (size - 1) & key.hashCode();
  }
}
