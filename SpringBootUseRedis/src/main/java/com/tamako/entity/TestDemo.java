package com.tamako.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/5 14:48
 */
@Data
public class TestDemo {

	@JsonProperty("pSkuId")
	private String pSkuId;

	private String pSkuIc;

}
