package com.tamako;

import com.tamako.test1.MathChecker;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MathCheckerTest {

	private int inputNumber;
	private Boolean expected;
	private MathChecker mathChecker;

	@Before
	public void setup() {
		mathChecker = new MathChecker();
	}

	public MathCheckerTest(int inputNumber, Boolean expected) {
		this.inputNumber = inputNumber;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> getTestData() {
		return Arrays.asList(new Object[][]{
				{1, true},
				{2, false},
				{3, true},
				{4, false},
				{5, true}
		});
	}

	@Test
	public void testisOdd() {
		System.out.println("Running test for:" + inputNumber);
		assertEquals(expected, mathChecker.isOdd(inputNumber));
	}

	@Test
	public void easyMockTest() {
		List list = EasyMock.createMock(List.class);
		// 录制过程

		// 期望方法list.set(0,1)执行2次，返回null，不抛出异常
		expect1:
		EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);
		// 期望方法list.set(0,1)执行1次，返回null，不抛出异常
		expect2:
		EasyMock.expect(list.set(0, 1)).andReturn(1);

		// 执行测试代码
		EasyMock.replay(list);
		// 执行list.set(0,1)，匹配expect1期望，会返回null
		Assert.assertNull(list.set(0, 1));
		// 执行list.set(0,1)，匹配expect1（因为expect1期望执行此方法2次），会返回null
		Assert.assertNull(list.set(0, 1));
		// 执行list.set(0,1)，匹配expect2，会返回1
		Assert.assertEquals(1, list.set(0, 1));

		// 验证期望
		EasyMock.verify(list);
	}

}