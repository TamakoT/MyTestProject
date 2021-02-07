package com.tamako.reflect.po;

import com.tamako.reflect.anno.TableField;
import com.tamako.reflect.anno.TableName;
import lombok.Data;

/**
 * <p>
 * 描述：测试数据实体类
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 14:48
 */
@Data
@TableName("TESTDATA")
public class DemoData {

	@TableField("ID")
	private Integer id;

	@TableField("NAME")
	private String name;

}
