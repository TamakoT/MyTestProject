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
 * @date 2021/1/19 11:53
 */
public class FinalStep implements Command {
	@Override
	public boolean execute(Context context) throws Exception {
		System.out.println("最后一步，输出最终用户信息");
		System.out.println("姓名：" + context.get("name") + " 电话：" + context.get("mobile"));
		return false;
	}
}
