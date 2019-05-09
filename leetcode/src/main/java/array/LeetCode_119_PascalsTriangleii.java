package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *  输入: 3
    输出: [1,3,3,1]
 * Created by xp-zhao on 2018/9/19.
 */
public class LeetCode_119_PascalsTriangleii
{
	public static void main(String[] args)
	{
		int n = 5;
		System.out.println(getRow(n));
		System.out.println(getRow1(n));
	}

	/** 
	* @Description: 个人解法，计算出每一行的数据 然后返回（不能达到 O(k) 的空间复杂度）
	* @Param:  
	* @return:  
	* @Author: zhaoxp
	* @Date: 2019/5/9 
	*/
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>(rowIndex + 1);
		List<Integer> temp = new ArrayList<>(rowIndex + 1);
		for(int i = 0; i < rowIndex + 1; i++){
			result = new ArrayList<>(rowIndex + 1);
			for(int j = 0; j <= i; j++){
				if(i == 0 || i== 1){
					result.add(1);
				}else{
					if(j != 0 && j != i){
						result.add(temp.get(j - 1) + temp.get(j));
					}else{
						result.add(1);
					}
				}
			}
			temp = result;
		}
		return result;
	}

	/**
	* @Description: 别人的优质解法，使用杨辉三角的规律：对应第 k 行，第 i + 1 项是第 i 项的 （k - i) / (i + 1) 倍
	* @Param:
	* @return:
	* @Author: zhaoxp
	* @Date: 2019/5/9
	*/
	public static List<Integer> getRow1(int rowIndex){
		List<Integer> result = new ArrayList<>(rowIndex + 1);
		long index = 1;
		for (int i = 0; i <= rowIndex; i++) {
			result.add((int) index);
			index = index * (rowIndex - i) / (i + 1);
		}
		return result;
	}
}
