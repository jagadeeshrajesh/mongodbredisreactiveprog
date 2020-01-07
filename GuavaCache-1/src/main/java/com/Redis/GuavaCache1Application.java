package com.Redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@EnableCaching
public class GuavaCache1Application {
	 
	
	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory(){ return new
	 * JedisConnectionFactory();
	 * 
	 * }
	 * 
	 * @Bean RedisTemplate<String, Employee> redisTemplate() { RedisTemplate<String,
	 * Employee> redisTemplate=new RedisTemplate<>();
	 * redisTemplate.setConnectionFactory(jedisConnectionFactory()); return
	 * redisTemplate; }
	 */
	/*
	 * @Bean ReactiveRedisOperations<String, Employee>
	 * redisOperations(ReactiveRedisConnectionFactory factory) {
	 * Jackson2JsonRedisSerializer<Employee> serializer = new
	 * Jackson2JsonRedisSerializer<>(Employee.class);
	 * 
	 * RedisSerializationContext.RedisSerializationContextBuilder<String, Employee>
	 * builder = RedisSerializationContext.newSerializationContext(new
	 * StringRedisSerializer());
	 * 
	 * RedisSerializationContext<String, Employee> context =
	 * builder.value(serializer).build();
	 * 
	 * return new ReactiveRedisTemplate<>(factory, context); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(GuavaCache1Application.class, args);
	}

}
