package com.tamako;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/19 16:04
 */
public class FirstFilter implements Filter {


	@Override
	public boolean postprocess(Context context, Exception exception) {
		System.out.println("111111要处理异常了哦");
		return false;
	}

	@Override
	public boolean execute(Context context) throws Exception {
		System.out.println("这是第1一1个异常处理过滤器");
		return false;
	}
}
