package com.tamako.test1;

public class MathChecker {

	/**
	 * 检查n是否为奇数
	 *
	 * @param n 被检查的数字
	 * @return true-奇数，false-偶数
	 */
	public Boolean isOdd(int n) {
		if (n % 2 != 0) {
			return true;
		} else {
			return false;
		}

	}
}