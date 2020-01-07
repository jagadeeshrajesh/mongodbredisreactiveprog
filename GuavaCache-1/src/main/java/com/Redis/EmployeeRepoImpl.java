package com.Redis;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EmployeeRepoImpl implements EmployeeRespository {
	
	  //private final ReactiveRedisConnectionFactory factory;
	  private final ReactiveRedisOperations<String, Employee> reactiveRedisOperations;
	  public EmployeeRepoImpl(ReactiveRedisOperations<String, Employee> reactiveRedisOperations) {
			super();
			this.reactiveRedisOperations = reactiveRedisOperations;
		}
		@Override
	
		public Mono<Employee> save(Employee emp) {
			String id=UUID.randomUUID().toString();
			return reactiveRedisOperations.opsForValue().set(id, emp).map(___->{
				return emp;
			});
		
		}
	  
	  @Override
	 
	  public Mono<Employee> findAll(String id) { // TODO Auto-generated
	  
		  return reactiveRedisOperations.opsForValue().get(id).map(res->{
			 return res;
		  });
		
		  
	 
	  }
	  
	  @Override 
	  public Mono<Boolean> delete(String id) { // TODO Auto-generated method stub
	return reactiveRedisOperations.opsForValue().delete(id);

	  
	  }
	  

	  
	  @Override 
	  public Mono<Object> update(String id) { 
		return reactiveRedisOperations.opsForValue().get(id)
		.flatMap(res->{
			res.setName(UUID.randomUUID().toString());
			return reactiveRedisOperations.opsForValue().set(id, res);
		
			
		});
	  }




	 

}
