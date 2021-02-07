package com.tamako.reflect.anno;

import java.lang.annotation.*;

/**
 * <p>
 * 描述：表名称
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 14:32
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableName {

	/**
	 * 修饰的实体类的表名
	 *
	 * @return 表名
	 */
	String value() default "";

}
