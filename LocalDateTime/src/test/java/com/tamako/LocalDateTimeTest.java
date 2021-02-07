package com.tamako;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 描述：关于LocalDateTime的测试
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/20 16:18
 */
public class LocalDateTimeTest {

	@Test
	public void oneTest() {
		System.out.println("-------------------------------------");
		LocalDateTime now = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		System.out.println(now);
		System.out.println(date);
		System.out.println(time);

		System.out.println("-------------------------------------");
		LocalDateTime now1 = LocalDateTime.now();
		LocalDate date1 = now1.toLocalDate();
		LocalTime time1 = now1.toLocalTime();
		System.out.println(now1);
		System.out.println(date1);
		System.out.println(time1);

		System.out.println("-------------------------------------");
		LocalDate date2 = LocalDate.of(1999, 9, 19);
		LocalTime time2 = LocalTime.of(18, 22, 37);
		LocalDateTime now2_1 = LocalDateTime.of(1999, 9, 19, 18, 22, 43);
		LocalDateTime now2_2 = LocalDateTime.of(date2, time2);
		System.out.println(now2_1);
		System.out.println(now2_2);
		System.out.println(date2);
		System.out.println(time2);

		System.out.println("-------------------------------------");
		LocalDateTime now3 = LocalDateTime.parse("1999-09-19T18:22:59");
		LocalDate date3 = LocalDate.parse("1999-09-19");
		LocalTime time3 = LocalTime.parse("18:23:27");
		System.out.println(now3);
		System.out.println(date3);
		System.out.println(time3);

		System.out.println("-------------------------------------");
	}

}
