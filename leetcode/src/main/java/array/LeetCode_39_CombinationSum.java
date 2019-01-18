package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的数字可以无限制重复被选取。

 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。

 示例 1:
 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]

 示例 2:
 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 *
 * Created by xp-zhao on 2019/1/18.
 */
public class LeetCode_39_CombinationSum
{
	public static void main(String[] args) {
		int[] candidates = {2 , 3 , 5};
		int target = 8;
		System.out.println(combinationSum(candidates,target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(candidates.length == 0){
			return result;
		}
		dfs(result,new LinkedList<>(),candidates,target,0);
		return result;
	}

	public static void dfs(List<List<Integer>> result, LinkedList<Integer> list, int[] candidates, int target, int index){
		int sum = list.stream().reduce(0,Integer::sum);
		if(sum >= target){
			if(sum == target){
				result.add(new ArrayList<>(list));
			}
			return;
		}else{
			for(int i = index; i < candidates.length; i++)
			{
				list.push(candidates[i]);
				dfs(result, list, candidates, target, i);
				list.pop();
			}
		}
	}
}
