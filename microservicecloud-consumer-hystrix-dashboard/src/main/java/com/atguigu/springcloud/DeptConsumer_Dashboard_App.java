package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard_App {
	public static void main(String[] args) {
		/*
		 * 这个项目microservicecloud-consumer-hystrix-dashboard可以独立直接启动,启动成功之后
		 * 在浏览器就可以直接访问http://localhost:9001/hystrix,就能看到hystrix的首页了。
		 * -------------------------------------------------------------
		 * 监控microservicecloud-provider-dept-hystrix-8001这个项目的的时候
		 * 先启动microservicecloud-eureka-7001,microservicecloud-eureka-7002,microservicecloud-eureka-7003
		 * 再启动microservicecloud-provider-dept-hystrix-8001,
		 * 最后再启动microservicecloud-consumer-hystrix-dashboard这个应用。
		 */
		SpringApplication.run(DeptConsumer_Dashboard_App.class, args);
	}
}
