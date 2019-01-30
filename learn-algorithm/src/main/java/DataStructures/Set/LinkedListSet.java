package DataStructures.Set;

import DataStructures.LinkedList.LinkedList;

/**
 * Created by xp-zhao on 2019/1/30.
 */
public class LinkedListSet<E> implements Set<E>
{
	private LinkedList<E> list;

	public LinkedListSet(){
		list = new LinkedList<>();
	}

	@Override
	public void add(E e)
	{
		if(!list.contains(e)){
			list.addFirst(e);
		}
	}

	@Override
	public void remove(E e)
	{
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e)
	{
		return list.contains(e);
	}

	@Override
	public int getSize()
	{
		return list.getSize();
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public static void main(String[] args) {
		LinkedListSet set = new LinkedListSet();
		set.add(1);
		set.add(2);
		set.add(1);
		System.out.println(set.getSize());
		System.out.println(set.contains(3));
	}
}
