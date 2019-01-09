package binarysearch;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

 示例:
 输入:
 letters = ["c", "f", "j"]
 target = "a"
 输出: "c"

 输入:
 letters = ["c", "f", "j"]
 target = "c"
 输出: "f"

 输入:
 letters = ["c", "f", "j"]
 target = "d"
 输出: "f"

 输入:
 letters = ["c", "f", "j"]
 target = "g"
 输出: "j"

 输入:
 letters = ["c", "f", "j"]
 target = "j"
 输出: "c"

 输入:
 letters = ["c", "f", "j"]
 target = "k"
 输出: "c"
 * Created by xp-zhao on 2019/1/9.
 */
public class LeetCode_744_FindSmallestLetterGreaterThanTarget
{
	public static void main(String[] args) {
		char[] letters = {'c' , 'f' , 'j'};
		System.out.println(nextGreatestLetter(letters , 'c'));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		if(target >= letters[right]){
			if(letters[0] == 'z'){
				return letters[1];
			}
			return letters[0];
		}
		while(left <= right){
			int middle = right - ((right - left) >> 1);
			if(letters[middle] > target){
				right = middle - 1;
			}else{
				left = middle + 1;
			}
		}
		return letters[left];
	}
}
