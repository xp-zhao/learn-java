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
public class PascalsTriangleii
{
	public static void main(String[] args)
	{
		int n = 3;
		System.out.println(getRow(n));
	}

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
}
