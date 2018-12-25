package BinarySearch;

/**
 * Created by xp-zhao on 2018/12/25.
 */
public class BinarySearch
{
	public static void main(String[] args) {
		int[] sortedArrays = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
		System.out.println(search(sortedArrays,10));
	}

	public static int search(int[] arrays,int value){
		int left = 0;
		int right = arrays.length - 1;
		while(left <= right){
			int middle = left + ((right - left) >> 1);
			if(arrays[middle] > value){
				right = middle - 1;
			}else if(arrays[middle] < value){
				left = middle + 1;
			}else{
				return middle;
			}
		}
		return -1;
	}
}
