package com.tamako.test3;

import org.junit.Test;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/4 11:41
 */
public class StringTest {

	public static void main(String[] args) {
		String s = "123456789";
		StringBuilder sb = new StringBuilder(s);
		StringBuilder replace = sb.replace(10, 10, "***");
		System.out.println(replace);
	}

	@Test
	public void oneTest() {
		String s = "你好，我要换行了：\n是的换行了！";
		System.out.println(s);
	}

	@Test
	public void enumTest() {
		StringTestEnum stringTestEnum1 = StringTestEnum.TEST_ONE;
		StringTestEnum stringTestEnum2 = null;
		switchEnum(stringTestEnum2);
	}

	public void switchEnum(StringTestEnum stringTestEnum) {
		switch (stringTestEnum) {
			case TEST_ONE:
				System.out.println(stringTestEnum);
				break;
			case TEST_TWO:
				System.out.println("测试2");
				break;
			case TEST_THREE:
				System.out.println("测试三：");
				System.out.println(stringTestEnum);
				break;
			default:
				System.out.println("什么都没有");
		}
	}

}
