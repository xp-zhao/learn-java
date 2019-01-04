package DataStructures.Queue;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class LinkedListQueue<E> implements Queue<E>
{
	private class Node{
		public E       e;
		public Node next;

		public Node(E e, Node next){
			this.e = e;
			this.next = next;
		}

		public Node(E e){
			this(e , null);
		}

		public Node(){
			this(null , null);
		}

		@Override
		public String toString(){
			return e.toString();
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedListQueue(){
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int getSize()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public void enQueue(E e)
	{
		if(tail == null){
			tail = new Node(e);
			head = tail;
		}else{
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E deQueue()
	{
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		Node result = head;
		head = head.next;
		result.next = null;
		if(head == null){
			tail = null;
		}
		size--;
		return result.e;
	}

	@Override
	public E getFront()
	{
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		return head.e;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: front ");
		Node current = head;
		while(current != null){
			sb.append(current + "->");
			current = current.next;
		}
		sb.append("null tail");
		return sb.toString();
	}

	public static void main(String[] args) {

		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
