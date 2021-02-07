package com.tamako.controller;

import com.tamako.entity.TestDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/5 14:49
 */
@RestController
public class TestController {

	@GetMapping("/getTest")
	public TestDemo getTest() {
		TestDemo test = new TestDemo();
		test.setPSkuId("111111111111111");
		test.setPSkuIc("222222222222222");
		return test;
	}

}
