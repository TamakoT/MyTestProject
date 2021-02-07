package com.tamako.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tamako.entity.User;
import com.tamako.mapper.UserMapper;
import com.tamako.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 16:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
