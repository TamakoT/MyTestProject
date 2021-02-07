package com.tamako.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 描述：关于Map的lambda使用
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/13 10:22
 */
public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "水水水水水");
		map.put(2, "金金金金金");
		map.put(3, "木木木木木");
		map.put(4, "火火火火火");
		map.put(5, "土土土土土");
		map.put(6, "咣咣咣咣咣");
		Map<Integer, String> collect = map.entrySet()
				.stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()));
		System.out.println(map);
	}

	@Test
	public void listTest() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "张三一号"));
		list.add(new User(2, "张三二号"));
		list.add(new User(3, "张三三号"));
		list.add(new User(1, "张三四号"));
		list.add(new User(2, "张三五号"));
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(User::getId, User::getName, (a, b) -> b));
		System.out.println(map);

	}

	@Data
	@AllArgsConstructor
	public static class User {
		Integer id;
		String name;
	}

}
