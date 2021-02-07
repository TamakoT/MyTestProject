package com.tamako;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/19 11:50
 */
public class ThirdStep implements Command {
	@Override
	public boolean execute(Context context) throws Exception {
		System.out.println("第三步，输出用户信息，并修改用户名");
		System.out.println("姓名：" + context.get("name") + " 电话：" + context.get("mobile"));
		context.put("name", "李六");
		return false;
	}
}
