package com.tamako.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tamako.entity.Order;
import com.tamako.mapper.OrderMapper;
import com.tamako.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/13 15:20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
