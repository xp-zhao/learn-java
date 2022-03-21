package LRU;

import java.util.LinkedHashMap;

/**
 * 使用 LinkedHashMap 实现 LRU 算法
 *
 * @author zhaoxiaoping
 * @date 2022-3-21
 */
public class LinkedHashMapCache {
  private int cap;
  private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

  public LinkedHashMapCache(int capacity) {
    this.cap = capacity;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    makeRecently(key);
    return cache.get(key);
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      cache.put(key, value);
      makeRecently(key);
      return;
    }
    if (cache.size() >= this.cap) {
      Integer first = cache.keySet().iterator().next();
      cache.remove(first);
    }
    cache.put(key, value);
  }

  private void makeRecently(int key) {
    int value = cache.get(key);
    cache.remove(key);
    cache.put(key, value);
  }
}
