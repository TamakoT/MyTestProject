package com.tamako.base;

import com.tamako.chain.TestDO;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/27 14:47
 */
public abstract class CheckBase implements Command {

	@Override
	public boolean execute(Context context) throws Exception {
		TestDO test = (TestDO) context.get("test");
		return doCheck(test);
	}

	/**
	 * 校验验主体
	 *
	 * @param test 参数
	 * @return 继续执行boolean变量（false表示继续向下一个校验器执行，true则开始反向执行后处理方法）
	 */
	public abstract boolean doCheck(TestDO test);

}
