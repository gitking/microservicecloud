package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/*
 * 必须先启动microservicecloud-provider-dept-8001这个微服务提供者(生产者)
 * 然后再启动microservicecloud-consumer-dept-80我这个微服务消费者
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.atguigu.springcloud"})
@ComponentScan("com.atguigu.springcloud")
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		/*
		 * Feign-Ribbon
		 * 注意Feign继承了Ribbon,利用Ribbon维护了
		 * MicroServiceCloud-Dept的服务列表信息,并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过Feign只需要定义服务绑定接口且以声明式的方法,优雅而简单的实现了服务调用。
		 */
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
