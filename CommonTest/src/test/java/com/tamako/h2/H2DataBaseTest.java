package com.tamako.h2;

import cn.hutool.core.map.MapUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 10:33
 */
public class H2DataBaseTest {

	@Test
	public void h2Test() throws IOException, ClassNotFoundException, SQLException {
		InputStream inputStream = H2DataBaseTest.class.getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);

		String driverClass = MapUtil.get(properties, "h2.driverClassName", String.class);
		String url = MapUtil.getStr(properties, "h2.url");
		String userName = MapUtil.getStr(properties, "h2.username");
		String password = MapUtil.getStr(properties, "h2.password");

		Class.forName(driverClass);

		Connection connection = DriverManager.getConnection(url, userName, password);
		String sql = "SELECT * FROM TESTDATA";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + resultSet.getString(2));
		}
		preparedStatement.close();
		connection.close();

	}

}
