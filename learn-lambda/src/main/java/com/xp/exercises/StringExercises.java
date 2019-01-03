package com.xp.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class StringExercises
{
	public static void main(String[] args) {
		String str = "asdcdADF";
		System.out.println(countLowercaseLetters(str));
		List<String> strings = Arrays.asList("asdfSDF" , "sdfsdfsdfsDfdf");
		System.out.println(mostLowercaseString(strings));
	}

	/**
	 * 统计字符串中小写字母的个数
	 * @param string
	 * @return
	 */
	public static int countLowercaseLetters(String string) {
		return (int) string.chars()
			.filter(Character::isLowerCase)
			.count();
	}

	/**
	 * 在一个字符串列表中，找出包含最多小写字母的字符串。
	 * @param strings
	 * @return
	 */
	public static Optional<String> mostLowercaseString(List<String> strings) {
		return strings.stream().max(Comparator.comparing(StringExercises::countLowercaseLetters));
	}
}
