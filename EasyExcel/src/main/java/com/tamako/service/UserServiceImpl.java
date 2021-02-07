package com.tamako.service;

import com.tamako.entity.User;

import java.util.List;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 17:15
 */
public class UserServiceImpl implements BaseService<User> {

	@Override
	public void save(List<User> list) {
		System.out.println("------------------------");
		list.forEach(System.out::println);
	}

}
