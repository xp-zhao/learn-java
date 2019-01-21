package DataStructures.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * Created by xp-zhao on 2019/1/9.
 */
public class QueueStack
{
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();

	/** Push element x onto stack. */
	public void push(int x) {
		queue2 = queue1;
		queue1 = new LinkedList<>();
		queue1.offer(x);
		while(!queue2.isEmpty()){
			queue1.offer(queue2.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue1.poll();
	}

	/** Get the top element. */
	public int top() {
		return queue1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty();
	}

	public static void main(String[] args) {
		QueueStack stack = new QueueStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
	}
}
