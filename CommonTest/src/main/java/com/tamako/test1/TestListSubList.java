package com.tamako.test1;

import com.tamako.po.TestModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/17 10:31
 */
public class TestListSubList {

	@Test
	public void oneTest() {
		List<TestModel> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(new TestModel(String.valueOf(i)));
		}
		List<String> strings = list.stream().map(this::convertString).collect(Collectors.toList());
		System.out.println(strings.size());
		strings.forEach(System.out::println);

		int page = 1;
		int pageSize = 0;
		List<TestModel> subList = list.subList((page - 1) * pageSize, pageSize * page);
		subList.forEach(System.out::println);
	}

	private String convertString(TestModel model) {
		if (Integer.parseInt(model.getTestValue()) % 2 == 0) {
			return null;
		}
		return model.getTestValue();
	}

}
