package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本地服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
public class DeptProvider8001_App {
	public static void main(String[] args) {
		/**
		 * 必须洗启动microservicecloud-config-3344这个配置中心项目,
		 * 再启动microservicecloud-config-eureka-client-7001这个eureka服务注册中心项目,
		 * 最后启动我们这个microservicecloud-config-dept-client-8001服务提供者项目
		 * 访问:http://localhost.:8001/dept/get/2
		 */
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
