package DataStructures.Stack;

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
	}
}
