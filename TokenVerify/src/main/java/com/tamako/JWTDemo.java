package com.tamako;

import com.tamako.util.JWTTokenUtil;

/**
 * <p>
 * 描述：jwt测试主类
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/19 15:40
 */
public class JWTDemo {

	public static void main(String[] args) {
		String username = "tamako";
		String password = "zyzt0919";
		//注意，一般不会把密码等私密信息放在payload中，这边只是举个列子
		String token = JWTTokenUtil.token(username, password);
		System.out.println(token);
		boolean b = JWTTokenUtil.verify(token);
		System.out.println(b);
	}

}
