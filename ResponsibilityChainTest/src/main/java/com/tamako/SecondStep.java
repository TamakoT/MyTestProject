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
public class SecondStep implements Command {
	@Override
	public boolean execute(Context context) throws Exception {
		System.out.println("第二步，设置用户手机号");
		context.put("mobile", "18992019291");
		return false;
	}
}
