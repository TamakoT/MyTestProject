package com.tamako.cycle;

import org.junit.Test;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/20 17:58
 */
public class TestTestA {

	@Test
	public void oneTest() {
		TestA testA = new TestA();
		TestA testA1 = new TestA();
		testA.setTestA(testA1);
		testA.test();
	}

}
