import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * Created by xp-zhao on 2018/8/7.
 */
public class TwoSum
{
	public static void main(String[] args)
	{
		int[] nums = {3,2,4};
		int[] result;
		result = towSum2(nums,6);
		for(int num : result)
		{
			System.out.println(num);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i = 0; i <  nums.length - 1; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i]+nums[j] == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public static int[] towSum2(int[] nums,int target) {
		int temp;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			temp = target - nums[i];
			if(map.containsKey(temp))
			{
				return new int[] {map.get(temp),i};
			}
			map.put(nums[i] , i);
		}
		return null;
	}
}
