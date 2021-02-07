package com.tamako.reflect.processor;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.tamako.reflect.anno.TableField;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 描述：数据处理器
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 14:51
 */
public class DataProcessor {

	public static <T> List<T> getList(ResultSet resultSet, Class<T> aClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Map<String, Field> fieldMap = getFieldMap(aClass);
		Set<String> keys = fieldMap.keySet();
		Constructor<T> constructor = aClass.getDeclaredConstructor();

		List<T> objects = CollectionUtil.newArrayList();
		while (resultSet.next()) {
			T object = constructor.newInstance();
			for (String key : keys) {
				Field field = fieldMap.get(key);
				field.set(object, resultSet.getObject(key, field.getType()));
			}
			objects.add(object);
		}
		return objects;
	}

	public static <T> T getOne(ResultSet resultSet, Class<T> aClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Map<String, Field> fieldMap = getFieldMap(aClass);
		Set<String> keys = fieldMap.keySet();
		Constructor<T> constructor = aClass.getDeclaredConstructor();

		if (resultSet.next()) {
			T object = constructor.newInstance();
			for (String key : keys) {
				Field field = fieldMap.get(key);
				field.set(object, resultSet.getObject(key, field.getType()));
			}
			return object;
		}
		return null;
	}

	private static <T> Map<String, Field> getFieldMap(Class<T> aClass) {
		Field[] fields = aClass.getDeclaredFields();
		Map<String, Field> fieldMap = MapUtil.newHashMap();
		for (Field field : fields) {
			TableField annotation = field.getAnnotation(TableField.class);
			String value = field.getName();
			if (annotation != null) {
				value = annotation.value();
			}
			field.setAccessible(true);
			fieldMap.put(value, field);
		}
		return fieldMap;
	}

}
