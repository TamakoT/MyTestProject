package com.tamako.constants.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wyh
 * @date 2021/1/21
 */
@Getter
@AllArgsConstructor
public enum OrderTagEnum implements ITagEnum {

	/**
	 * 位置对应的状态
	 */
	GROUP(1, "拼团"),
	POINT(2, "积分");

	/**
	 * 获取对应状态在二进制数中状态所处的位置数值（从右往左）
	 */
	private int position;

	/**
	 * 状态备注，对应的是什么状态
	 */
	private String memo;
}