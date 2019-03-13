package stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * Created by xp-zhao on 2019/3/13.
 */
public class LeetCode_232_ImplementQueueUsingStacks
{
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	public LeetCode_232_ImplementQueueUsingStacks(){

	}

	public static void main(String[] args) {
		LeetCode_232_ImplementQueueUsingStacks queue = new LeetCode_232_ImplementQueueUsingStacks();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.peek());
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while(!stack1.empty()){
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		while(!stack2.empty()){
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
}
