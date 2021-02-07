package com.tamako.reflect;

import com.tamako.reflect.po.DemoData;
import com.tamako.reflect.processor.DataProcessor;
import com.tamako.reflect.util.DataBaseUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 描述：H2数据库的测试
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 16:15
 */
public class H2DataTest {

	public static void main(String[] args) {
		String sql = "SELECT * FROM TESTDATA";
		try (Connection connection = DataBaseUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<DemoData> list = DataProcessor.getList(resultSet, DemoData.class);
			list.forEach(System.out::println);
		} catch (SQLException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}

}
