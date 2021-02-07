package com.tamako.chain;

import com.tamako.*;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/19 11:55
 */
public class TestChain extends ChainBase {

	private static TestChain chain = new TestChain();

	private TestChain() {
		super();
		addCommand(new FirstStep());
		addCommand(new FirstFilter());
		addCommand(new SecondStep());
		addCommand(new SecondFilter());
		addCommand(new ThirdStep());
		addCommand(new FinalStep());
	}

	public static void main(String[] args) throws Exception {
		//Chain chain = new TestChain();
		Context context = new ContextBase();
		TestDO testDO = new TestDO();
		testDO.setName("张三");
		context.put("test", testDO);
		System.out.println(testDO);
		System.out.println(chain.execute(context));
		System.out.println(testDO);
	}

}
