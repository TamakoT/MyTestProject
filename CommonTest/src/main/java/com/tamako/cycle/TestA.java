package com.tamako.cycle;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/20 17:55
 */
public class TestA {

	private TestA testA;

	public TestA() {
	}

	public void setTestA(TestA a) {
		testA = a;
	}

	public void test() {
		if (testA != null) {
			testA.test();
		}
		System.out.println("hello");
	}

}
