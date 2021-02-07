package com.tamako.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wyh
 * @date 2021/1/21
 */
@AllArgsConstructor
@Getter
public enum TagFlagEnum {

	/**
	 * 对应的状态位的1和0分别代表的含义
	 */
	YES(1, "是"),
	NO(0, "否");

	private int flag;

	private String memo;
}