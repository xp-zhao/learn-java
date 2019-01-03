package DataStructures.Arrays;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class Main
{
	public static void main(String[] args) {
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = i;
//		}
//		System.out.println(Arrays.toString(arr));
//		int[] scores = new int[]{1 , 2 , 3 , 4 , 5};
//		System.out.println(Arrays.toString(scores));
//		scores[0] = 5;
//		System.out.println(Arrays.toString(scores));
		Array<Integer> arr = new Array<>(10);
		for(int i = 0; i < 10; i++){
			arr.addLast(i);
		}
		System.out.println(arr);
		arr.add(1,100);
		System.out.println(arr);
		arr.addFirst(-1);
		System.out.println(arr);
		arr.remove(2);
		System.out.println(arr);
		arr.removeElement(4);
		System.out.println(arr);
		arr.removeFirst();
		System.out.println(arr);
	}
}
