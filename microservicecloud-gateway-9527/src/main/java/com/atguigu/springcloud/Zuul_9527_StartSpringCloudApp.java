package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {
	public static void main(String[] args) {
		/**
		 * 先启动microservicecloud-eureka-7001,microservicecloud-eureka-7002,microservicecloud-eureka-7003
		 * 然后再启动microservicecloud-provider-dept-8001,
		 * 最后在启动:microservicecloud-gateway-9527
		 * 然后再浏览器上通过zuul访问:http://myzuul.com:9527/microservicecloud-dept/dept/get/2
		 * 如果开启别名的话,通过http://myzuul.com:9527/mydept/dept/get/2访问
		 * 如果开启前缀功能的话,通过http://myzuul.com:9527/atguigu/mydept/dept/get/3 访问
		 */
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}
}
