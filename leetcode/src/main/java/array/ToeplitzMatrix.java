package array;

/**
 * 766. 托普利茨矩阵
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
  给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
	 输入:
	 matrix = [
	 [1,2,3,4],
	 [5,1,2,3],
	 [9,5,1,2]
	 ]
	 输出: True
	 解释:
	 在上述矩阵中, 其对角线为:
	 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
	 各条对角线上的所有元素均相同, 因此答案是True。
 * Created by xp-zhao on 2018/9/18.
 */
public class ToeplitzMatrix
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1 , 2 },{2,2}};
		System.out.println(isToeplitzMatrix(matrix));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(i != 0 && j != 0){
					if(matrix[i][j] != matrix[i - 1][j - 1]){
						return false;
					}
				}
			}
		}
		return true;
	}
}
