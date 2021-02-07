package com.tamako.test4;

import com.tamako.po.TestFather;
import com.tamako.po.TestSon;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/27 11:00
 */
public class FatherSonTest {

	public static void main(String[] args) {
		TestFather father = new TestSon();
		father.setDetail("father = new son");
		father.setName("father out (son in)");
		father.setSn("fatherSon1111111");
		System.out.println(father);
	}

}
