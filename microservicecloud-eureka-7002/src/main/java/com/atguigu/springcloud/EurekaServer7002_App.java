package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器启动类,接受其他微服务注册进来
public class EurekaServer7002_App {
	public static void main(String[] args) {
		/*
		 * 直接启动,启动成功之后访问
		 * http://localhost:7001/
		 */
		SpringApplication.run(EurekaServer7002_App.class, args);
	}
}
