package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * Created by xp-zhao on 2019/3/13.
 */
public class LeetCode_225_ImplementStackUsingQueues
{
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();

	public static void main(String[] args) {
		LeetCode_225_ImplementStackUsingQueues stack = new LeetCode_225_ImplementStackUsingQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
	}

	public LeetCode_225_ImplementStackUsingQueues() {

	}

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
}
