package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(StandardCharsets.UTF_8.displayName());
		System.out.println(StandardCharsets.UTF_8.name());
		System.out.println(StandardCharsets.UTF_8.toString());
	}

}
