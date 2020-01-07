package com.Redis;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux

public class EmployeeRouter {


	@Bean
	  public RouterFunction<ServerResponse> getAll(EmployeeHandler showHandler) {
	 
	  return RouterFunctions .
			 route(RequestPredicates.GET("/getAllData/{id}"),showHandler::getdata); 
	  }
	  
	 
	@Bean
	public RouterFunction<ServerResponse> postdata(EmployeeHandler handler) {
		return RouterFunctions.route(
				RequestPredicates.POST("/postdata").and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
				handler::postdata);
	}

	

	 
	  @Bean 
	 public RouterFunction<ServerResponse> delete(EmployeeHandler handler) {
		  return
		  RouterFunctions.route(RequestPredicates.DELETE("/deleteAll/{id}"),handler::delete)
		  ; }

		 
	  @Bean 
	 public RouterFunction<ServerResponse> update(EmployeeHandler handler) {
		  return
		  RouterFunctions.route(RequestPredicates.DELETE("/deleteAll/{id}"),handler::delete)
		  ; }

}
