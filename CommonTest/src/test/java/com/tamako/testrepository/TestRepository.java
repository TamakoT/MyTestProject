package com.tamako.testrepository;

import com.tamako.testmodel.TestModel;

import java.time.LocalDateTime;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/3 16:28
 */
public class TestRepository {

	public TestModel dealTestModel(TestModel testModel) {
		testModel.setBirth(LocalDateTime.now());
		testModel.setAge((int) (Math.random() % 100));
		testModel.setDesc("想象一下自己身处无边无际的大海之中");
		return testModel;
	}

}
