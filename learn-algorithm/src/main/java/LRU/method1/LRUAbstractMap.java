package LRU.method1;

import java.util.AbstractMap;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xp-zhao on 2018/12/24.
 */
public class LRUAbstractMap extends AbstractMap
{
	public static final int MAX_SIZE = 1024;
	public static final ArrayBlockingQueue<Node> QUEUE = new ArrayBlockingQueue<Node>(MAX_SIZE);
	public static final int DEFAULT_ARRAY_SIZE = 1024;

	private int arraySize;
	private Object[] arrays;
	private volatile AtomicInteger size;

	public LRUAbstractMap(){
		arraySize = DEFAULT_ARRAY_SIZE;
		arrays = new Object[arraySize];
	}

	@Override
	public Object put(Object key,Object value){
		int hash = hash(key);
		int index = hash % arraySize;
		Node currentNode = (Node) arrays[index];
		if(currentNode == null){
			arrays[index] = new Node(null , null , key , value);
			QUEUE.offer((Node) arrays[index]);
			sizeUp();
		}else{
			Node cNode = currentNode;
			Node nNode = cNode;
			if(nNode.getKey() == key){
				cNode.setValue(value);
			}
			while(nNode.getNext() != null){
				if(nNode.getKey() == key){
					nNode.setValue(value);
					break;
				}else{
					sizeUp();
					Node node = new Node(nNode , null , key , value);
					QUEUE.offer(currentNode);
					cNode.setNext(node);
				}
				nNode = nNode.getNext();
			}
		}
		return null;
	}

	/**
	 * 增加 size
	 */
	private void sizeUp(){
		if(size == null){
			size = new AtomicInteger();
		}
		int size = this.size.incrementAndGet();
		if(size >= MAX_SIZE){
			// 获取队列头的数据
			Node node = QUEUE.poll();
			remove(node.getKey());
		}
	}

	/**
	 * 减少 size
	 */
	private void sizeDown(){
		if(QUEUE.size() == 0){
//			flag = false;
		}
		this.size.decrementAndGet();
	}

	@Override
	public int size(){
		return size.get();
	}

	public int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	@Override
	public Set<Entry> entrySet()
	{
		return super.keySet();
	}
}
