package com.Redis;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;



import reactor.core.publisher.Mono;
@Component
public class EmployeeHandler {
	
	@Autowired
	EmployeeRepoImpl emp;
	
	 
	
	
	  public Mono<ServerResponse> getdata(ServerRequest serverRequest) {
String id=serverRequest.pathVariable("id");
	  return ServerResponse.ok().body(emp.findAll(id),Employee.class);
	  }
	 
	 
	
	
	 
	  public Mono<ServerResponse> postdata(ServerRequest serverRequest) {
	
		  
		return serverRequest.bodyToMono(Employee.class).flatMap(empl->{
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
    		body(emp.save(empl), Employee.class);
		});
	}
	
	  public Mono<ServerResponse> update(ServerRequest serverRequest) {
		  String id=serverRequest.pathVariable("id");
		  return ServerResponse.ok().body(emp.update(id),Employee.class);
	
		}
	  public Mono<ServerResponse> delete(ServerRequest serverRequest) {
		  String id=serverRequest.pathVariable("id");
		  return ServerResponse.ok().body(emp.delete(id),Employee.class);
	
		}

}
