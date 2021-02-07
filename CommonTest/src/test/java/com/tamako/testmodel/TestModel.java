package com.tamako.testmodel;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/3 16:30
 */
@Data
public class TestModel {

	private String name;

	private Integer age;

	private String desc;

	private LocalDateTime birth;

}
