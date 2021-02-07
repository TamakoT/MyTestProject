package com.tamako.tag;

import com.tamako.constants.enums.ITagEnum;
import com.tamako.constants.enums.TagFlagEnum;
import lombok.Data;

/**
 * tag对
 *
 * @author wyh
 * @date 2021/1/21
 */
@Data
public class TagPair {

	private ITagEnum tagEnum;

	private TagFlagEnum flagEnum;
}