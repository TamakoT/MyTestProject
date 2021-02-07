package com.tamako;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tamako.po.Order;
import com.tamako.service.OrderService;
import com.tamako.service.impl.OrderServiceImpl;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/13 15:21
 */
public class Test {

	public static void main(String[] args) {
		OrderService orderService = new OrderServiceImpl();

		Page<Order> orderPage = orderService.page(new Page<>(1, 10),
				new QueryWrapper<Order>()
						.orderByAsc("id"));

		for (Order record : orderPage.getRecords()) {
			System.out.println(record);
		}
	}

}
