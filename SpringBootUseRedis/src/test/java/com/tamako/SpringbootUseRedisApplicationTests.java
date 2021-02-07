package com.tamako;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tamako.entity.Order;
import com.tamako.entity.User;
import com.tamako.service.IUserService;
import com.tamako.service.OrderService;
import com.tamako.util.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootUseRedisApplicationTests {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private IUserService userService;

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
		;
	}

	@Test
	public void readTest() {
		String fileName = "D://userDemo.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(fileName, User.class, ExcelUtil.getDataListener(userService, 5)).sheet().doRead();

		/*
		// 写法2：
		fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
		ExcelReader excelReader = null;
		try {
			excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
			ReadSheet readSheet = EasyExcel.readSheet(0).build();
			excelReader.read(readSheet);
		} finally {
			if (excelReader != null) {
				// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
				excelReader.finish();
			}
		}
		*/
	}

	@Test
	public void writeTest() {
		String fileName = "D://userDemoWriter.xlsx";
		EasyExcel.write(fileName, User.class).sheet("用户数据写入测试").doWrite(userService.list());
	}

	@Test
	public void mybatisPlusTest() {
//		Page<Order> orderPage = orderService.page(new Page<>(29734, 10),
//				new QueryWrapper<Order>()
//						.orderByAsc("created_at", "paid_at"));

		Page<Order> orderPage = orderService.page(new Page<>(29734, 10),
				new QueryWrapper<Order>()
						.orderByAsc("created_at")
						.orderByAsc("paid_at"));

		System.out.println(orderPage.getSize());
		for (Order record : orderPage.getRecords()) {
			//System.out.println(record);
			System.out.println("{ id: " + record.getId() + ", created_at : " + record.getCreatedAt() + ", paid_at : " + record.getPaidAt() + " }");
		}
	}

}
