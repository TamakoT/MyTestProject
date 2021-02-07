package com.tamako.constants.enums;

/**
 * @author wyh
 * @date 2021/1/21
 */
public interface ITagEnum {

	/**
	 * 获取对应状态在二进制数中状态所处的位置数值（从右往左）
	 *
	 * @return 十进制数
	 */
	int getPosition();

	/**
	 * 获取对应的状态为的含义
	 *
	 * @return 状态含义
	 */
	String getMemo();
}