package bitmap;

import java.util.Arrays;

/**
 * 大数据情况下，判断一个数是否在指定的一组数中
 * 1. 申请足够大的位，2 的 32 次方个位覆盖所有整数范围
 * 2. 遍历给定的所有数据，将数据对应下标的数组位为设置为 1
 * 3. 新来一个数 n 时，直接找数组第 n 位的值，为 1 则存在，为 0 则不存在
 *
 * 	40 亿个 32 位的 int 数据，全部放入内存中需要 40 * 4 = 160 亿个字节，大约需要 16g 内存
 * 	采用位图法，一个 32 位的数据只需要一位就可以表示，只需要 1/32 的内存，大约只需要 500M 的内存
 *
 * Created by xp-zhao on 2018/12/25.
 */
public class BitMapDemo
{
	public static void main(String[] args) {
		byte[] bitmap = new byte[32];
		int[] nums = {1 , 4 , 6 , 30 , 31 , 8 , 10};
		for(int num : nums)
		{
			bitmap[num] = 1;
		}
		System.out.println(Arrays.toString(bitmap));
		int num = 5;
		System.out.println(isExist(num,bitmap));
	}

	public static boolean isExist(int num,byte[] bitmap){
		if(bitmap[num] == 0){
			return false;
		}
		return true;
	}
}
