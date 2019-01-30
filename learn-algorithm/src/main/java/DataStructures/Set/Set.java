package DataStructures.Set;

/**
 * Created by xp-zhao on 2019/1/30.
 */
public interface Set<E>
{
	void add(E e);

	void remove(E e);

	boolean contains(E e);

	int getSize();

	boolean isEmpty();
}
