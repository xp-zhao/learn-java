package Heap;

import java.util.ArrayList;

/**
 * Created by xp-zhao on 2018/12/25.
 */
public class MinHeap <E extends Comparable<E>>
{
	private ArrayList<E> data;

	public MinHeap(int capacity){
		data = new ArrayList<E>(capacity);
	}

	public MinHeap(){
		data = new ArrayList<E>();
	}

	public int size(){
		return data.size();
	}

	public boolean isEmpty(){
		return data.isEmpty();
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    	private int parent(int index){
		return (index - 1) / 2;
    	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index){
    		return index * 2 + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	private int rightChild(int index){
		return index * 2 + 2;
	}
}
