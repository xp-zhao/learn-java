package DataStructures.Set;

import BST.BST;

/**
 * Created by xp-zhao on 2019/1/30.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>
{
	private BST<E> bst;

	public BSTSet(){
		bst = new BST<E>();
	}

	@Override
	public void add(E e)
	{
		bst.add(e);
	}

	@Override
	public void remove(E e)
	{
		bst.remove(e);
	}

	@Override
	public boolean contains(E e)
	{
		return bst.contains(e);
	}

	@Override
	public int getSize()
	{
		return bst.size();
	}

	@Override
	public boolean isEmpty()
	{
		return bst.isEmpty();
	}

	public static void main(String[] args) {
		BSTSet set = new BSTSet();
		set.add(1);
		set.add(1);
		System.out.println(set.getSize());
		System.out.println(set.isEmpty());
	}
}
