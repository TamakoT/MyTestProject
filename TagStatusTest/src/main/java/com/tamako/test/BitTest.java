package com.tamako.test;

import org.junit.Test;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/22 13:58
 */
public class BitTest {

	@Test
	public void oneTest() {
		int a = 0B0101;
		int b = 1;
		int c = (a & 0B10 << b) >> b;
		System.out.println(c);
	}

	@Test
	public void twoTest() {
		int a = 0B1000_0000_0000_0000_0000_0000_0000_0000;
		System.out.println(a);
	}

}
