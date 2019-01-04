package DataStructures.Queue;

import DataStructures.Arrays.Array;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class ArrayQueue<E> implements Queue<E>
{
	private Array<E> array;

	public ArrayQueue(int capacity){
		array = new Array<>(capacity);
	}

	public ArrayQueue(){
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

	public int getCapaCity(){
		return array.getCapacity();
	}

	@Override
	public void enQueue(E e)
	{
		array.addLast(e);
	}

	@Override
	public E deQueue()
	{
		return array.removeFirst();
	}

	@Override
	public E getFront()
	{
		return array.getFirst();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: ");
		sb.append("front [");
		for(int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1){
				sb.append(", ");
			}
		}
		sb.append("] tail");
		return sb.toString();
	}

	public static void main(String[] args) {

		ArrayQueue<Integer> queue = new ArrayQueue<>();
		for(int i = 0; i < 10; i++)
		{
			queue.enQueue(i);
			System.out.println(queue);
			if(i % 3 == 2){
				queue.deQueue();
				System.out.println(queue);
			}
		}
	}
}
