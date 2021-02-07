package com.tamako.test5;

import com.tamako.po.TestModel;
import org.junit.Test;

import java.util.Optional;

/**
 * <p>
 * 描述：关于Optional的使用
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/1 14:29
 */
public class OptionalTest {

	@Test
	public void oneTest() {
		TestModel testModel = new TestModel();
		testModel.setTestValue("有测试值，从测试对象中获取的值");
		TestModel testModel1 = new TestModel();
		System.out.println(Optional.ofNullable(testModel.getTestValue()).orElse("无测试值，从optional获取"));
		System.out.println(Optional.ofNullable(testModel1.getTestValue()).orElse("无测试值，从optional获取"));
	}

}
