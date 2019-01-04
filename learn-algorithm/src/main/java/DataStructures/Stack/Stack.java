package DataStructures.Stack;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public interface Stack<E>{
	int getSize();

	boolean isEmpty();

	void push(E e);

	E pop();

	E peek();
}
