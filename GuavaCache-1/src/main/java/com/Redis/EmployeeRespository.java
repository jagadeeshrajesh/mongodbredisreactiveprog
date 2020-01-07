package com.Redis;
import reactor.core.publisher.Mono;
public interface EmployeeRespository{

	Mono<Employee> findAll(String id);
	Mono<Object> update(String id);
	Mono<Boolean> delete(String id);
	Mono<Employee> save(Employee emp);
}
