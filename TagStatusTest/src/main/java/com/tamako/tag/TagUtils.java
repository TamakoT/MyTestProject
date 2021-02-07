package com.tamako.tag;

import com.tamako.constants.enums.ITagEnum;
import com.tamako.constants.enums.TagFlagEnum;

/**
 * @author wyh
 * @date 2021/1/21
 */
public class TagUtils {

	/**
	 * 判断标志位状态
	 *
	 * @param tagNumber 状态字段的值
	 * @param iTagEnum  状态位枚举
	 * @return
	 */
	public boolean tagStatus(int tagNumber, ITagEnum iTagEnum) {
		int offset = iTagEnum.getPosition() - 1;
		return (tagNumber & (0x1 << offset) >> offset) == TagFlagEnum.YES.getFlag();
	}

	/**
	 * 设置状态位
	 *
	 * @param tagNumber
	 * @param tagPairs
	 * @return
	 */
	public int setTagStatus(int tagNumber, TagPair... tagPairs) {
		if (null == tagPairs || tagPairs.length == 0) {
			return tagNumber;
		}
		int initTag = tagNumber;
		for (TagPair tagPair : tagPairs) {
			int number = Double.valueOf(Math.pow(2, tagPair.getTagEnum().getPosition() - 1)).intValue();
			if (tagPair.getFlagEnum() == TagFlagEnum.YES) {
				initTag = initTag | number;
			} else {
				initTag = initTag & (~number);
			}
		}
		return initTag;
	}
}