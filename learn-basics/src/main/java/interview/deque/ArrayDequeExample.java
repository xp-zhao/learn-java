package interview.deque;

import com.alibaba.fastjson.JSON;
import java.util.ArrayDeque;
import java.util.Deque;

/** @author zhaoxiaoping @Description: 双端队列示例 @Date 2021-9-27 */
public class ArrayDequeExample {
  public static void main(String[] args) {
    arraycopy();
  }

  public static void arraycopy() {
    int head = 0, tail = 0;
    Object[] elements = new Object[8];
    elements[head = (head - 1) & (elements.length - 1)] = "a";
    elements[head = (head - 1) & (elements.length - 1)] = "b";
    elements[head = (head - 1) & (elements.length - 1)] = "c";
    elements[head = (head - 1) & (elements.length - 1)] = "d";
    elements[tail] = "e";
    tail = (tail + 1) & (elements.length - 1);
    elements[tail] = "f";
    tail = (tail + 1) & (elements.length - 1);
    elements[tail] = "g";
    tail = (tail + 1) & (elements.length - 1);
    elements[tail] = "h";
    tail = (tail + 1) & (elements.length - 1);
    System.out.println("head： " + head);
    System.out.println("tail： " + tail);
    int p = head;
    int n = elements.length;
    // number of elements to the right of p
    int r = n - p;
    // 输出当前的元素
    System.out.println(JSON.toJSONString(elements));
    // head == tail 扩容
    Object[] a = new Object[8 << 1];
    System.arraycopy(elements, p, a, 0, r);
    System.out.println(JSON.toJSONString(a));
    System.arraycopy(elements, 0, a, r, p);
    System.out.println(JSON.toJSONString(a));
    elements = a;
    head = 0;
    tail = n;
    a[head = (head - 1) & (a.length - 1)] = "i";
    elements[tail] = "j";
    tail = (tail + 1) & (elements.length - 1);
    System.out.println(JSON.toJSONString(a));
  }

  public static void userExample() {
    Deque<String> deque = new ArrayDeque<String>(1);
    deque.push("a");
    deque.push("b");
    deque.push("c");
    deque.push("d");
    deque.offerLast("e");
    deque.offerLast("f");
    deque.offerLast("g");
    deque.offerLast("h");
    deque.push("i");
    deque.offerLast("j");
    System.out.println(deque);
    while (!deque.isEmpty()) {
      System.out.print(deque.pop() + " ");
    }
  }
}
