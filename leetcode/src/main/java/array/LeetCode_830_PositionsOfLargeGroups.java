package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 示例 2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 */
public class LeetCode_830_PositionsOfLargeGroups {
    public static void main(String[] args) {
        String str = "abbxxxxzzy";
        System.out.println(largeGroupPositions(str));
        System.out.println(largeGroupPositions1(str));
        String str1 = "abc";
        System.out.println(largeGroupPositions(str1));
        System.out.println(largeGroupPositions1(str1));
        String str2 = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(str2));
        System.out.println(largeGroupPositions1(str2));
        String str3 = "aaa";
        System.out.println(largeGroupPositions(str3));
        System.out.println(largeGroupPositions1(str3));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char[] ch = S.toCharArray();
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if(i == 0 || ch[i] != ch[i - 1]){
                if(list.size() >= 3){
                    temp.add(list.get(0));
                    temp.add(list.get(list.size() - 1));
                    result.add(temp);
                    temp = new ArrayList<>();
                }
                list = new ArrayList<>();
                list.add(i);
            }else{
                list.add(i);
            }
        }
        if(list.size() >= 3){
            temp.add(list.get(0));
            temp.add(list.get(list.size() - 1));
            result.add(temp);
        }
        return result;
    }

    /**
     * 优化解法
     * @param S
     * @return
     */
    public static List<List<Integer>> largeGroupPositions1(String S) {
        char[] ch = S.toCharArray();
        List<List<Integer>> result = new ArrayList<>();
        int count = 1;
        int start = 0;
        for(int i = 1; i < ch.length; i++)
        {
            if(ch[i] == ch[i - 1]){
                count++;
            }else{
                if(count >= 3){
                    result.add(Arrays.asList(start,i - 1));
                }
                count = 1;
                start = i;
            }
        }
        if(count >= 3){
            result.add(Arrays.asList(start,ch.length - 1));
        }
        return result;
    }
}
