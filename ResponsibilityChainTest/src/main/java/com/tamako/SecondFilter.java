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
 * @date 2021/1/19 16:09
 */
public class SecondFilter implements Filter {

	@Override
	public boolean postprocess(Context context, Exception exception) {
		System.out.println("222222表示根本没有异常要处理呀");
		return false;
	}

	@Override
	public boolean execute(Context context) throws Exception {
		System.out.println("这是第2二2个异常过滤器");
		return false;
	}

}
