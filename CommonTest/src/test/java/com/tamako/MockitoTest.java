package com.tamako;

import cn.hutool.core.util.ReflectUtil;
import com.tamako.testmodel.TestModel;
import com.tamako.testrepository.TestRepository;
import com.tamako.testservice.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * <p>
 * 描述：测试Mockito的使用
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/2/3 14:03
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

//	//手动初始化mock模拟对象
//
//	private AutoCloseable autoCloseable;
//
//	@Before
//	public void initMocks() {
//		autoCloseable = MockitoAnnotations.openMocks(MockitoTest.class);
//	}
//
//	@After
//	public void afterTest() throws Exception {
//		autoCloseable.close();
//	}

	public MockitoTest() {
		Assert.assertNotNull(mockList);
		Assert.assertNotNull(testService);
		Assert.assertNotNull(testRepository);
	}

	@Mock
	List<String> mockList;

	@Test(expected = RuntimeException.class)
	public void mockitoTest() {

		System.out.println(mockList.getClass());
		Assert.assertNotNull(mockList);

		//设置方法执行返回值
		when(mockList.add("张三")).thenReturn(true);
		when(mockList.size()).thenReturn(10);

		Assert.assertTrue(mockList.add("张三"));
		Assert.assertTrue(mockList.add("张三"));

		Assert.assertFalse(mockList.add("李四"));

		Assert.assertEquals(10, mockList.size());

		System.out.println(mockList.get(0));

		//验证方法执行次数
		verify(mockList, never()).addAll(null);

		verify(mockList, times(1)).get(0);
		verify(mockList, times(2)).add("张三");

		verify(mockList, atLeast(1)).add("李四");

		verify(mockList, atMost(2)).size();

		//验证方法是否超时
		verify(mockList, timeout(100)).size();

		//验证方法是否超时可以结合上边的验证执行次数一起使用（即验证每次执行是否超时）
		verify(mockList, timeout(100).times(1)).size();

		//设置参数及返回值
		when(mockList.get(anyInt())).thenReturn("everyIndexResult");
		System.out.println(mockList.get(13));

		//设置抛出的异常
		doThrow(new RuntimeException()).when(mockList).add("1");
		mockList.add("1");

	}

	@InjectMocks
	private TestService testService;

	@Mock
	private TestRepository testRepository;

	@Test
	public void ServiceTest() {
		TestModel testModel = new TestModel();
		testModel.setName("我是测试model呀");
		testModel.setAge(1000);
		testModel.setDesc("测试的描述一直都是如此朴实无华");
		testModel.setBirth(LocalDateTime.now());

		when(testRepository.dealTestModel(any())).thenReturn(testModel);
		ReflectUtil.setFieldValue(testService, "testRepository", testRepository);

		System.out.println(testService.test("张四"));
	}

}
