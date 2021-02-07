package com.tamako.test2;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 描述：本地时间格式化测试
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/28 9:22
 */
public class LocalDateTimeTest {

	@Test
	public void oneTest() {
		String fileName = "运单号_" + DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss").format(LocalDateTime.now());
		System.out.println(fileName);
	}

}
