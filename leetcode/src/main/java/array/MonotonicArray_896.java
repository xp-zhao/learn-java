package array;

/**
 * 	896. 单调数列
 * 	如果数组是单调递增或单调递减的，那么它是单调的。
 	如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 	当给定的数组 A 是单调数组时返回 true，否则返回 false。

	 示例 1：
	 输入：[1,2,2,3]
	 输出：true

	 示例 2：
	 输入：[6,5,4,4]
	 输出：true

	 示例 3：
	 输入：[1,3,2]
	 输出：false

	 示例 4：
	 输入：[1,2,4,5]
	 输出：true

	 示例 5：
	 输入：[1,1,1]
	 输出：true
 * Created by xp-zhao on 2018/11/13.
 */
public class MonotonicArray_896
{
	public static void main(String[] args)
	{
		int[] array = {6 ,6,5,4,4};
		System.out.println(method1(array) || method2(array));

	}

	public static boolean method1(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			if(array[i + 1] > array[i]){
				return false;
			}
		}
		return true;
	}
	public static boolean method2(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			if(array[i + 1] < array[i]){
				return false;
			}
		}
		return true;
	}

}
