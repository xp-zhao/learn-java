package DataStructures.Queue;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public interface Queue<E>
{
	int getSize();

	boolean isEmpty();

	void enQueue(E e);

	E deQueue();

	E getFront();
}
