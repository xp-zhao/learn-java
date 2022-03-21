package LRU;

import lombok.Data;

/**
 * @author xp-zhao
 * @date 2018/12/24
 */
@Data
public class Node<K, V> {
  private K key;
  private V value;
  Node<K, V> prev;
  Node<K, V> next;

  public Node(K k, V v) {
    this.key = k;
    this.value = v;
  }
}
