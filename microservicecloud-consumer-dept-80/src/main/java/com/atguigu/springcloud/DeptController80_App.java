package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

/*
 * 必须先启动microservicecloud-provider-dept-8001这个微服务提供者(生产者)
 * 然后再启动microservicecloud-consumer-dept-80我这个微服务消费者
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类,从而使配置生效。针对MICROSERVICECLOUD-DEPT这个微服务使用我们自定义的负载均衡算法
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration=MySelfRule.class)
public class DeptController80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptController80_App.class, args);
	}
}
