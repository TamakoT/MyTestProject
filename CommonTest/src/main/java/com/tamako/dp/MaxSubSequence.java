package com.tamako.dp;

/**
 * <p>
 * 描述：最长递增子序列
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/8 17:41
 */
public class MaxSubSequence {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 4, 3, 4, 2};
		System.out.println(findMaxSubSeq(nums));
	}

	/**
	 * 获取给的数组中能找到的最长递增子序列长度
	 * 思路：
	 * 设计dp数组为一维数组，类型与给定的数组类型一致，
	 * dp数组dp[i]记录数组中以arr[i]位置的数结尾的最长递增子序列长度，
	 * 这么设计之后，解题就变得较为轻松
	 *
	 * @param arr 需要找出最长递增子序列长度的数组
	 * @return 最长递增子序列的长度
	 */
	public static int findMaxSubSeq(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] += dp[j];
					break;
				}
			}
		}

		int length = -1;
		for (int i = 0; i < n; i++) {
			if (dp[i] > length) {
				length = dp[i];
			}
		}

		return length;
	}

}
