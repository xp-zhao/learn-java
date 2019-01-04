package DataStructures.Stack;

import java.util.Random;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class Main
{
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		for(int i = 0; i < 5; i++)
		{
			stack.push(i);
			System.out.println(stack);
		}
		stack.pop();
		System.out.println(stack);
		LinkedListStack<Integer> listStack = new LinkedListStack<>();
		for(int i = 0; i < 5; i++)
		{
			listStack.push(i);
			System.out.println(listStack);
		}
		listStack.pop();
		System.out.println(listStack);
		int oprCount = 100000;
		ArrayStack<Integer> arrayStack = new ArrayStack<>();
		double time1 = testStack(arrayStack, oprCount);
		System.out.println("ArrayStack, time: " + time1 + " s");
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
		double time2 = testStack(linkedListStack, oprCount);
		System.out.println("LinkedListStack, time: " + time2 + " s");
	}

	private static double testStack(Stack<Integer> stack,int oprCount){
		long startTime = System.nanoTime();
		Random random = new Random();
		for(int i = 0; i < oprCount; i++)
		{
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0; i < oprCount; i++)
		{
			stack.pop();
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}
}
