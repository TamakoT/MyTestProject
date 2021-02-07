package com.tamako.test1;

import cn.hutool.core.collection.CollectionUtil;
import com.tamako.po.TestModel;
import org.junit.Test;

import java.util.Map;

/**
 * <p>
 * 描述：测试map的get方法返回值
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/17 9:31
 */
public class TestMapGetMethod {

	@Test
	public void oneTest() {
		Map<Integer, TestModel> map = CollectionUtil.newHashMap();
		map.put(1, new TestModel("11111111111"));
		System.out.println(map.get(2));
		System.out.println(map.get(1));
	}

}
