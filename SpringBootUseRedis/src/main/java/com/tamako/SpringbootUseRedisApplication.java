package com.tamako;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author User
 */
@MapperScan("com.tamako.mapper")
@SpringBootApplication
public class SpringbootUseRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUseRedisApplication.class, args);
	}

}
