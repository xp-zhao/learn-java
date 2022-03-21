package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 LRU 缓存
 *
 * @author zhaoxiaoping
 * @date 2022-3-21
 */
public class MyLRUCache {
  private Map<Integer, Node> map;
  private DoubleList cache;
  private int cap;

  public MyLRUCache(int capacity) {
    this.cap = capacity;
    map = new HashMap<>();
    cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    // 将该数据修改为最近使用的数据
    makeRecently(key);
    return (int) map.get(key).getValue();
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // 删除旧数据
      deleteKey(key);
      // 添加新数据
      addRecently(key, value);
      return;
    }
    if (cap == cache.size()) {
      // 删除最久未使用的数据
      removeLeastRecently();
    }
    // 添加新数据
    addRecently(key, value);
  }

  /**
   * 将某个 key 提升为最近使用的
   *
   * @param key 关键字
   */
  private void makeRecently(int key) {
    Node x = map.get(key);
    cache.remove(x);
    cache.addLast(x);
  }

  /**
   * 添加最近使用的元素
   *
   * @param key 关键字
   * @param value 值
   */
  private void addRecently(int key, int value) {
    Node x = new Node(key, value);
    cache.addLast(x);
    map.put(key, x);
  }

  /**
   * 删除指定的 key
   *
   * @param key 关键字
   */
  private void deleteKey(int key) {
    Node x = map.get(key);
    cache.remove(x);
    map.remove(key);
  }

  /** 删除最近未使用的元素 */
  private void removeLeastRecently() {
    Node first = cache.removeFirst();
    Integer firstKey = (Integer) first.getKey();
    map.remove(firstKey);
  }
}
