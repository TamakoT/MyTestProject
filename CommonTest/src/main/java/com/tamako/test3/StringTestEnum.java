package com.tamako.test3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/29 15:24
 */
@Getter
@AllArgsConstructor
@ToString
public enum StringTestEnum {

	/**
	 *
	 */
	TEST_ONE(1, "测试一"),
	TEST_TWO(2, "测试二"),
	TEST_THREE(3, "测试三"),
	;

	private Integer code;

	private String desc;

}
