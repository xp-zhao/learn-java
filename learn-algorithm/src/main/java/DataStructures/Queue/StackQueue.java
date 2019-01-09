package DataStructures.Queue;

import java.util.Stack;

/**
 * 使用栈实现队列
 * Created by xp-zhao on 2019/1/9.
 */
public class StackQueue
{
	Stack<Integer> stack1 = new Stack<>(); // 存储空间
	Stack<Integer> stack2 = new Stack<>(); // 缓冲区

	/** Push element x to the back of queue. */
	public void push(int x) {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack1.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack1.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty();
	}

	public static void main(String[] args) {
		StackQueue stackQueue = new StackQueue();
		stackQueue.push(2);
		stackQueue.push(3);
		System.out.println(stackQueue.peek());
	}
}
