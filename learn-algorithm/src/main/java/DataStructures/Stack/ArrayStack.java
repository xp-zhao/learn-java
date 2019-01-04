package DataStructures.Stack;

import DataStructures.Arrays.Array;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class ArrayStack<E> implements Stack<E>
{
	Array<E> array;

	public ArrayStack(int capacity)
	{
		array = new Array<>(capacity);
	}

	public ArrayStack(){
		array = new Array<>();
	}

	@Override
	public int getSize()
	{
		return array.getSize();
	}

	@Override
	public boolean isEmpty()
	{
		return array.isEmpty();
	}

	@Override
	public void push(E e)
	{
		array.addLast(e);
	}

	@Override
	public E pop()
	{
		return array.removeLast();
	}

	@Override
	public E peek()
	{
		return array.getLast();
	}

	public int getCapaCity()
	{
		return array.getCapacity();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: ");
		sb.append("[");
		for(int i = 0; i < array.getSize(); i++)
		{
			sb.append(array.get(i));
			if(i != array.getSize() - 1){
				sb.append(", ");
			}
		}
		sb.append("] top");
		return sb.toString();
	}
}
