package com.tamako;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.tamako.entity.User;
import com.tamako.service.UserServiceImpl;
import com.tamako.util.ExcelUtil;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 17:18
 */
public class EasyExcelDemo {

	public static void main(String[] args) throws FileNotFoundException {
		write();
	}

	public static void write() throws FileNotFoundException {
		String fileName = "D://userDemoWriter.xlsx";
		ExcelWriter writer = EasyExcel.write(fileName, User.class).build();
		WriteSheet sheet = EasyExcel.writerSheet("score").build();
		try {
			for (int j = 0; j < 100; j++) {
				List<User> data = new ArrayList<>();
				for (int i = 0; i < 100; i++) {
					User user = new User();
					user.setName(String.format("Name-%d-%d", j, i));
					user.setNumber(String.format("Number-%d-%d", j, i));
					user.setBirth(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
					data.add(user);
				}
				writer.write(data, sheet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.finish();
			}
		}
	}

	public static void read() {
		String fileName = "D://userDemo.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(fileName, User.class, ExcelUtil.getDataListener(new UserServiceImpl(), 5)).sheet().headRowNumber(1).doRead();
	}

}
