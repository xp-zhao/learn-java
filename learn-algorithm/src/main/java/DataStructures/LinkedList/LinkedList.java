package DataStructures.LinkedList;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class LinkedList<E>
{
	private class Node{
		public E e;
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

	private Node dummyHead;
	int size;

	public LinkedList(){
		dummyHead = new Node(null , null);
		size = 0;
	}

	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 在链表头添加新的元素
	 * @param e
	 */
	public void addFirst(E e){
//		Node node = new Node(e);
//		node.next = head;
//		head = node;
		add(0,e);
	}

	/**
	 * 在链表的 index 位置添加新元素 e
	 * @param index
	 * @param e
	 */
	public void add(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed, Index is illegal.");
		}
		Node prev = dummyHead;
		for(int i = 0; i < index; i++)
		{
			prev = prev.next;
		}
//			Node node = new Node(e);
//			node.next = prev.next;
//			prev.next = node;
		prev.next = new Node(e , prev.next);
		size++;
	}

	/**
	 * 在链表末尾添加新的元素
	 * @param e
	 */
	public void addLast(E e){
		add(size , e);
	}

	/**
	 * 获取链表的 index 位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed, Index is illegal.");
		}
		Node current = dummyHead.next;
		for(int i = 0; i < index; i++)
		{
			current = current.next;
		}
		return current.e;
	}

	/**
	 * 获取链表第一个元素
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}

	/**
	 * 获取链表最后一个元素
	 * @return
	 */
	public E getLast(){
		return get(size - 1);
	}

	/**
	 * 修改链表中第 index 个元素
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed, Index is illegal.");
		}
		Node current = dummyHead.next;
		for(int i = 0; i < index; i++)
		{
			current = current.next;
		}
		current.e = e;
	}

	/**
	 * 查找链表中是否有元素 e
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		Node current = dummyHead.next;
		while(current != null){
			if(current.e.equals(e)){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * 删除链表中 index 位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed, Index is illegal.");
		}
		Node prev = dummyHead;
		for(int i = 0; i < index; i++)
		{
			prev = prev.next;
		}
		Node result = prev.next;
		prev.next = result.next;
		result.next = null;
		size--;
		return result.e;
	}

	/**
	 * 删除链表第一个元素
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}

	/**
	 * 删除链表最后一个元素
	 * @return
	 */
	public E removeLast(){
		return remove(size - 1);
	}

	/**
	 * 从链表中删除元素 e
	 * @param e
	 */
	public void removeElement(E e){
		Node prev = dummyHead;
		while(prev.next != null){
			if(prev.next.e.equals(e)){
				break;
			}
			prev = prev.next;
		}
		if(prev.next != null){
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node current = dummyHead.next;
		while(current != null){
			sb.append(current + "->");
			current = current.next;
		}
		sb.append("null");
		return sb.toString();
	}
}
