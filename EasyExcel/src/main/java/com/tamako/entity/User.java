package com.tamako.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 17:12
 */
@Data
public class User {

	@ColumnWidth(20)
	@ExcelProperty("姓名")
	private String name;

	@ColumnWidth(20)
	@ExcelProperty("编号")
	private String number;

	@ColumnWidth(20)
	@ExcelProperty("生日")
	private String birth;

}
