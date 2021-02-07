package com.tamako.dp;

import lombok.Data;

/**
 * <p>
 * 描述：斜着读取数组的方法测试
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/8 16:26
 */
public class DiagonalArray {

	public static void main(String[] args) {
		int[] stones = new int[]{3, 9, 1, 2};
		int n = stones.length;
		GameUnit[][] dp = stoneGame(stones);
		System.out.println(dp[0][n - 1].getFirst() - dp[0][n - 1].getSecond());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 石堆博弈问题动态规划解决办法（两个玩家都非常精明，那么先后手的差距就是一个定值）
	 *
	 * @param stones 石头堆（数组的长度就是石头堆数，每个位置的数值就是每堆多少个石头）
	 * @return 两个精明玩家先手和后手的结果差距
	 */
	public static GameUnit[][] stoneGame(int[] stones) {
		int n = stones.length;
		GameUnit[][] dp = new GameUnit[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = new GameUnit(0, 0);
			}
		}

		for (int l = 0; l < n; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = i + l;

				if (i == j) {
					dp[i][j].setFirst(stones[i]);
					continue;
				}

				int left = stones[i] + dp[i + 1][j].getSecond();
				int right = stones[j] + dp[i][j - 1].getSecond();

				if (left > right) {
					dp[i][j].setFirst(left);
					dp[i][j].setSecond(dp[i + 1][j].getFirst());
				} else {
					dp[i][j].setFirst(right);
					dp[i][j].setSecond(dp[i][j - 1].getFirst());
				}

			}
		}

		return dp;
	}

	@Data
	public static class GameUnit {
		private int first;
		private int second;

		GameUnit(int fir, int sec) {
			this.first = fir;
			this.second = sec;
		}

		@Override
		public String toString() {
			return String.format("(%-4d,%-4d)", first, second);
		}

	}

	/**
	 * 斜方向遍历数组参考代码
	 */
	private static void test1() {
		int n = 10;
		int[][] arr = new int[n][n];
		int num = 1;

		//斜着遍历长宽相等的二维数组的主体部分
		for (int l = 0; l < n; l++) {
			//i对应行，j对应列
			for (int i = 0; i < n - l; i++) {
				int j = i + l;

				//需要按斜方向操作二维数组元素的代码放在这儿
				arr[i][j] = num++;

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%-4d", arr[i][j]);
			}
			System.out.println();
		}
	}

}
