package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本地服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
@EnableCircuitBreaker//启用Hystrix熔断机制
public class DeptProvider8001_Hystrix_App {
	public static void main(String[] args) {
		/**
		 * 先启动microservicecloud-eureka-7001,microservicecloud-eureka-7003,microservicecloud-eureka-7002这三个项目
		 * 注意测试的时候只启动microservicecloud-provider-dept-hystrix-8001和microservicecloud-consumer-dept-80这个项目, microservicecloud-provider-dept-8001
		 * microservicecloud-provider-dept-8002
		 * microservicecloud-provider-dept-8003这是项目不用启动。
		 * 启动成功之后再浏览器上测试访问:http://localhost:8001/dept/get/1
		 */
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}
}
