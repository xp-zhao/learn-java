package KMP;

import java.util.Arrays;

/**
 * Created by xp-zhao on 2018/12/26.
 */
public class KMPDemo
{
	public static void main(String[] args) {
		String target = "banananobano";
		String pattern = "ABCDABD";
		System.out.println(Arrays.toString(initNext(pattern)));
		System.out.println(match(target,pattern));

	}

	public static int match(String target,String pattern){
		char[] targetArray = target.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int targetLength = target.length();
		int patternLength = pattern.length();
		int targetIndex = 0;
		int patternIndex = 0;
		while(targetIndex < targetLength && patternIndex < patternLength){
			if(targetArray[targetIndex] == patternArray[patternIndex]){
				targetIndex++;
				patternIndex++;
			}else{
				targetIndex -= patternIndex - 1;// tagetIndex = tagetIndex - patternIndex + 1;
				patternIndex = 0;
			}
		}
		if(patternIndex == patternLength){
			return targetIndex - patternLength;
		}
		return -1;
	}

	/**
	 * 生成部分匹配表
	 * @param pattern
	 * @return
	 */
	public static int[] initNext(String pattern){
		char[] patternArray = pattern.toCharArray();
		int[] next = new int[pattern.length()];
		next[0] = 0;
		int i, j;
		for(i = 1, j = 0; i < pattern.length(); i++){
			while(j > 0 && patternArray[i] != patternArray[j]){
				j = next[j - 1];
			}
			if(patternArray[i] == patternArray[j]){
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
