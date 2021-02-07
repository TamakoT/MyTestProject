package com.tamako.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 描述：Redis相关配置
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 11:24
 */
@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(stringRedisSerializer);
		template.setValueSerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setHashValueSerializer(stringRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	@ConditionalOnMissingBean(StringRedisTemplate.class)
	public StringRedisTemplate stringRedisTemplate(
			RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
