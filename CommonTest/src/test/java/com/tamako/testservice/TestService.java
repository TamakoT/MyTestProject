package com.tamako.testservice;

import com.tamako.testmodel.TestModel;
import com.tamako.testrepository.TestRepository;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/3 16:27
 */
public class TestService {

	private TestRepository testRepository;

	public TestService() {
		testRepository = new TestRepository();
	}

	public TestModel test(String name) {
		TestModel testModel = new TestModel();
		testModel.setName(name);
		testModel = testRepository.dealTestModel(testModel);
		return testModel;
	}

}
