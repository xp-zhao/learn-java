package DataStructures.Heap;

import DataStructures.Arrays.Array;

import java.util.Random;

/**
 * Created by xp-zhao on 2019/1/30.
 */
public class MaxHeap<E extends Comparable>
{
	private Array<E> data;

	public MaxHeap(int capacity){
		data = new Array<>(capacity);
	}

	public MaxHeap(){
		data = new Array<>();
	}

	/**
	 * 返回堆中元素的个数
	 * @return
	 */
	public int size(){
		return data.getSize();
	}

	/**
	 * 判断堆是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
	 * @param index
	 * @return
	 */
	private int parent(int index){
		if(index == 0){
			throw new IllegalArgumentException("index-0 doesn't have parent");
		}
		return (index - 1) / 2;
	}

	/**
	 *返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return index * 2 + 2;
	}

	/**
	 * 向堆中添加元素
	 * @param e
	 */
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	private void siftUp(int k){
		while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	/**
	 * 取出堆中最大元素
	 * @return
	 */
	public E extractMax(){
		E ret = findMax();
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);
		return ret;
	}

	private void siftDown(int k){
		while(leftChild(k) < data.getSize()){
			 int j = leftChild(k);
			 if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
//			 	j++;
				 j = rightChild(k);
			 }
			 if(data.get(k).compareTo(data.get(j)) >= 0){
			 	break;
			 }
			 data.swap(k,j);
			 k = j;
		}
	}

	/**
	 * 找到堆中最大元素
	 * @return
	 */
	public E findMax(){
		if(data.getSize() == 0){
			throw new IllegalArgumentException("Can not findMax when heap is empty");
		}
		return data.get(0);
	}

	public static void main(String[] args) {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for(int i = 0; i < n; i++)
		{
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = maxHeap.extractMax();
		}
		for(int i = 1; i < n; i++)
		{
			if(arr[i] > arr[i - 1]){
				throw new IllegalArgumentException("Error");
			}
		}
		System.out.println("Test MaxHeap completed");
	}
}
