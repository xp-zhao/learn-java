package LRU;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 最少使用次数的数据淘汰算法
 *
 * @author zhaoxiaoping
 * @date 2022-3-22
 */
public class LFUCache {

  /** 保存 key 到 val 的映射 */
  private HashMap<Integer, Integer> keyToVal;
  /** 保存 key 到 freq 的映射 */
  private HashMap<Integer, Integer> keyToFreq;
  /** 保存 freq 到 key 列表的映射 */
  private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
  /** 记录最小的访问频次 */
  private int minFreq;
  /** 记录 LFUCache 缓存的最大容量 */
  private int cap;

  public LFUCache(int capacity) {
    this.keyToFreq = new HashMap<>();
    this.keyToFreq = new HashMap<>();
    this.freqToKeys = new HashMap<>();
    this.minFreq = 0;
    this.cap = capacity;
  }

  public int get(int key) {
    if (!keyToVal.containsKey(key)) {
      return -1;
    }
    // 增加 key 对应的 freq
    increaseFreq(key);
    return keyToVal.get(key);
  }

  public void put(int key, int val) {
    if (this.cap <= 0) {
      return;
    }
    // 若 key 已经存在，则直接修改对应的 val，并更新 freq
    if (keyToVal.containsKey(key)) {
      keyToVal.put(key, val);
      // key 对应的 freq 加一
      increaseFreq(key);
      return;
    }
    // 若缓存容量已满，则需要删除一个 freq 最小的 key
    if (this.cap <= keyToVal.size()) {
      removeMinFreqKey();
    }
    keyToVal.put(key, val);
    keyToFreq.put(key, 1);
    freqToKeys.computeIfAbsent(1, v -> new LinkedHashSet<>()).add(key);
    this.minFreq = 1;
  }

  private void increaseFreq(int key) {
    int freq = keyToFreq.get(key);
    keyToFreq.put(key, freq + 1);
    freqToKeys.get(freq).remove(key);
    freqToKeys.computeIfAbsent(freq + 1, v -> new LinkedHashSet()).add(key);
    if (freqToKeys.get(freq).isEmpty()) {
      freqToKeys.remove(freq);
      if (freq == this.minFreq) {
        this.minFreq++;
      }
    }
  }

  private void removeMinFreqKey() {
    // freq 最小的 key 列表
    LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
    // 最先插入的 key 就是要删除的
    Integer deleteKey = keyList.iterator().next();
    keyList.remove(deleteKey);
    if (keyList.isEmpty()) {
      freqToKeys.remove(deleteKey);
    }
    keyToVal.remove(deleteKey);
    keyToFreq.remove(deleteKey);
  }
}
