package DataStructures.LinkedList;

/**
 * @description: 利用哨兵简化编程难度
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class SentinelDemo {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    System.out.println(find1(array, 3));
    System.out.println(find2(array, 3));
  }

  // 从数组 array 中查找 key，并返回 key 所在的位置
  public static int find1(int[] array, int key) {
    int length = array.length;
    if (length <= 0) {
      return -1;
    }
    int i = 0;
    // 此处有两个比较操作，i < length 与 array[i] == key
    while (i < length) {
      if (array[i] == key) {
        return i;
      }
      i++;
    }
    return -1;
  }

  // 从数组 array 中查找 key，并返回 key 所在的位置(使用哨兵)
  public static int find2(int[] array, int key) {
    int length = array.length;
    if (length <= 0) {
      return -1;
    }
    // 特殊处理最后一个值
    if (array[length - 1] == key) {
      return length - 1;
    }
    // 将最后一个值保存在临时变量中，方便之后恢复
    // array: [1,2,3,4,5,6]
    // key: 3
    // temp: 6
    int temp = array[length - 1];
    // 将 key 的值放入 array[length - 1] 中
    // [1,2,3,4,5,3]
    array[length - 1] = key;
    int i = 0;
    // 相比 find1 此处少了 i < length 的判断
    while (array[i] != key) {
      i++;
    }
    // 恢复数组的值，[1,2,3,4,5,6]
    array[length - 1] = temp;
    if (i == length - 1) {
      // 如果 i == length - 1,说明 0 ~ length - 2 之间没有 key
      return -1;
    } else {
      return i;
    }
  }
}