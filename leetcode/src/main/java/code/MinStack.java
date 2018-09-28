package code;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 实现一个最小栈，这个栈除了可以进行普通的push、pop操作以外，还可以进行getMin的操作，getMin方法被调用后，会返回当前栈的最小值
 * Created by xp-zhao on 2018/9/28.
 */
public class MinStack
{
	private List<Integer> data = new ArrayList<>();
	// 辅助栈，保存最小值索引
	private List<Integer> mins = new ArrayList<>();

	public void push(int num)
	{
		data.add(num);
		if(mins.size() == 0){
			// 初始化 mins
			mins.add(0);
		}else{
			int min = getMin();
			if(num < min){
				// 如果当前 push 的值小于最小值，则保存当前值的索引
				mins.add(data.size() - 1);
			}
		}
	}

	public int pop()
	{
		// 栈空
		if(data.size() == 0)
		{
			throw new EmptyStackException();
		}
		// 获取要 pop 的数据的索引
		int popIndex = data.size() - 1;
		// 获取最小值的索引（mins 栈顶元素）
		int minIndex = mins.get(mins.size() - 1);
		if(popIndex == minIndex){
			// 如果 pop 出去的元素的索引等于最小值的索引，则 mins 出栈
			mins.remove(mins.size() - 1);
		}
		return data.remove(data.size() - 1);
	}

	public int getMin()
	{
		if(mins.size() == 0){
			throw new EmptyStackException();
		}
		// mins 栈顶元素为最小值索引
		int minIndex = mins.get(mins.size() - 1);
		return data.get(minIndex);
	}

	public static void main(String[] args)
	{
		MinStack stack = new MinStack();
		stack.push(2);
		System.out.println(stack.getMin());
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
	}
}
