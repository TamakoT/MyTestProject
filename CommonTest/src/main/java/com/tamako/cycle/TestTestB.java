package com.tamako.cycle;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/21 14:25
 */
public class TestTestB {

	@Test
	public void oneTest() {
		TestB testB = JSON.parseObject("{\"allName\":\"Tamako\",\"userPhone\":\"17171771\"}", TestB.class);
		System.out.println(testB);
		String s = JSON.toJSONString(testB);
		System.out.println(s);
	}

}
