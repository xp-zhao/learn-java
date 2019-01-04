package DataStructures.Queue;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class LoopQueue<E> implements Queue<E>
{
	private E[] data;
	private int front;
	private int tail;
	private int size;

	public LoopQueue(int capacity){
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQueue(){
		this(10);
	}

	public int getCapaCity(){
		return data.length - 1;
	}

	@Override
	public int getSize()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return front == tail;
	}

	@Override
	public void enQueue(E e)
	{
		if((tail + 1) % data.length == front){
			resize(getCapaCity() << 1);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	private void resize(int newCapaCity){
		E[] newData = (E[]) new Object[newCapaCity + 1];
		for(int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public E deQueue()
	{
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		E result = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if(size == getCapaCity() >> 2 && getCapaCity() >> 1 != 0){
			resize(getCapaCity() >> 1);
		}
		return result;
	}

	@Override
	public E getFront()
	{
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty.");
		}
		return data[front];
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapaCity()));
		sb.append("front [");
		for(int i = front; i != tail; i = (i + 1) % data.length) {
			sb.append(data[i]);
			if((i + 1) % data.length != tail){
				sb.append(", ");
			}
		}
		sb.append("] tail");
		return sb.toString();
	}
}
