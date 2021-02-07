package com.tamako.reflect.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 描述：实体类的字段对应的表中字段名
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 14:38
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableField {

	/**
	 * 标注的属性字段在数据库中的对应字段名
	 *
	 * @return 数据库中的对应字段名
	 */
	String value() default "";

}
