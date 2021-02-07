package com.tamako.reflect.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.db.ds.simple.SimpleDataSource;
import cn.hutool.log.Log;
import com.tamako.reflect.processor.DataProcessor;
import org.h2.tools.RunScript;
import org.h2.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>
 * 描述：数据库工具
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/7 15:04
 */
public class DataBaseUtil {

	private static Log log = Log.get(DataBaseUtil.class);

	private static DataSource dataSource;

	static {
		InputStream inputStream = DataProcessor.class.getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String driverClass = MapUtil.get(properties, "h2.driverClassName", String.class);
		String url = MapUtil.getStr(properties, "h2.url");
		String userName = MapUtil.getStr(properties, "h2.username");
		String password = MapUtil.getStr(properties, "h2.password");
		String initFile = MapUtil.getStr(properties, "h2.init.file");

		dataSource = new SimpleDataSource(url, userName, password, driverClass);

		if (!StringUtils.isNullOrEmpty(initFile)) {
			try (Connection connection = dataSource.getConnection();) {
				RunScript.execute(connection, FileUtil.getUtf8Reader(initFile));
			} catch (SQLException e) {
				log.error(e, "初始化内存数据库失败，请检查初始化脚本文件[{}]是否存在，或内存是否足够", initFile);
				e.printStackTrace();
			}
		}

	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
