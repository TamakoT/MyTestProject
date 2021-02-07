package com.tamako;

import com.tamako.base.CheckBase;
import com.tamako.chain.TestDO;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/19 11:48
 */
public class FirstStep extends CheckBase {

	@Override
	public boolean doCheck(TestDO test) {
		test.setName("第一步修改为李四");
		return false;
	}

}
