package DataStructures.Queue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author zhaoxiaoping
 * @Description: 使用两个栈实现队列
 * @Date 2020-6-16
 **/
public class MyQueue {

  private Stack<Integer> stack1 = new java.util.Stack<>();
  private Stack<Integer> stack2 = new java.util.Stack<>();

  public void push(Integer node) {
    stack1.push(node);
  }  
  
  public Integer pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack2.pop();
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
  }
}
