package DataStructures.Arrays;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class Array<E>
{
	private E[] data;
	private int size;

	/**
	 * 构造函数，指定数组容量 capacity
	 * @param capacity
	 */
	public Array(int capacity){
		data = (E[]) new Object[capacity];
		size = 0;
	}

	/**
	 * 无参构造函数，默认大小为 10
	 */
	public Array(){
		this(10);
	}

	/**
	 * 获取数组中的元素个数
	 * @return
	 */
	public int getSize(){
		return size;
	}

	/**
	 * 获取数组的容量
	 * @return
	 */
	public int getCapacity(){
		return data.length;
	}

	/**
	 * 数组是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 在最后添加新元素
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}

	/**
	 * 在头部添加新元素
	 * @param e
	 */
	public void addFirst(E e){
		add(0 , e);
	}

	/**
	 * 将元素插入到指定位置
	 * @param index
	 * @param e
	 */
	public void add(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
		}
		if(size == data.length){
			resize(data.length << 1);
		}
		for(int i = size - 1; i >= index; i--){
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	/**
	 * 扩容
	 * @param newCapacity
	 */
	private void resize(int newCapacity){
		E[] newData = (E[]) new Object[newCapacity];
		for(int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 获取指定索引的元素
	 * @param index
	 * @return
	 */
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed, Index is illegal.");
		}
		return data[index];
	}

	public E getLast(){
		return get(size - 1);
	}

	public E getFirst(){
		return get(0);
	}

	/**
	 * 修改指定索引的元素
	 * @param index
	 * @param e
	 */
	public void set(int index, E e){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed, Index is illegal.");
		}
		data[index] = e;
	}

	/**
	 * 判断数组中是否包含指定元素
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		for(int i = 0; i < size; i++)
		{
			if(data[i].equals(e)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找指定元素的索引，不存在则返回 -1
	 * @param e
	 * @return
	 */
	public int find(E e){
		for(int i = 0; i < size; i++)
		{
			if(data[i].equals(e)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 删除指定索引的元素，返回删除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Remove failed, Index is illegal.");
		}
		E temp = data[index];
		for(int i = index + 1; i < size; i++){
			data[i - 1] = data[i];
		}
		size--;
		if(size == data.length >> 1){
			resize(data.length >> 1);
		}
		return temp;
	}

	/**
	 * 删除数组的第一个元素
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}

	/**
	 * 删除数组的最后一个元素
	 * @return
	 */
	public E removeLast(){
		return remove(size - 1);
	}

	public void removeElement(E e){
		int index = find(e);
		if(index != -1){
			remove(index);
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
		sb.append("[");
		for(int i = 0; i < size; i++) {
			sb.append(data[i]);
			if(i != size - 1){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
