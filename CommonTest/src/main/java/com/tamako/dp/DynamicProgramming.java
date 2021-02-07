package com.tamako.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 * 描述：动态规划解决斐波那契数列
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/6 16:51
 */
public class DynamicProgramming {

	/**
	 * 不带备忘录
	 *
	 * @param n 第几位的位值
	 * @return 斐波那契数列第n位的数值
	 */
	public static int fb0(int n) {
		if (n == 2 || n == 1) {
			return 1;
		}
		return fb0(n - 1) + fb0(n - 2);
	}

	/**
	 * 带备忘录
	 *
	 * @param map 结果记录器
	 * @param n   第几位的位值
	 * @return 斐波那契数列第n位的数值
	 */
	public static int fb1(int[] map, int n) {
		if (n == 2 || n == 1) {
			return 1;
		}
		if (map[n] != 0) {
			return map[n];
		}
		map[n] = fb1(map, n - 1) + fb1(map, n - 2);
		return map[n];
	}

	@Test
	public void oneTest() {
		int n = 45;

		long start = System.currentTimeMillis();
		System.out.println("fb0 with " + n + " : " + fb0(n));
		long end = System.currentTimeMillis();
		System.out.println("fb0 use time : " + (end - start));

		int[] map = new int[n + 1];
		Arrays.fill(map, 0);
		start = System.currentTimeMillis();
		System.out.println("fb1 with " + n + " : " + fb1(map, n));
		end = System.currentTimeMillis();
		System.out.println("fb1 use time : " + (end - start));
	}

}
