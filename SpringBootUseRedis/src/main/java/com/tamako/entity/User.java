package com.tamako.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tamako.entity.convert.LocalDateTimeConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 描述：user信息
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 15:34
 */
@Data
@TableName("user")
public class User {

	@ExcelProperty("姓名")
	@TableField("name")
	private String name;

	@ExcelProperty("编号")
	@TableField("number")
	private String number;

	@ExcelProperty(value = "生日", converter = LocalDateTimeConverter.class)
	@TableField("birth")
	private LocalDateTime birth;

}
