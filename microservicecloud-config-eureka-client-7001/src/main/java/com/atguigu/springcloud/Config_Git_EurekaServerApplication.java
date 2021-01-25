package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器启动类,接受其他微服务注册进来
public class Config_Git_EurekaServerApplication {
	public static void main(String[] args) {
		/*
		 * 一定要先启动microservicecloud-config-3344这个项目,因为我们这个microservicecloud-config-eureka-client-7001项目启动的时候
		 * 会去请求microservicecloud-config-3344这个项目,通过microservicecloud-config-3344这个项目去访问github上面的yml配置文件
		 * 再根据获取到的配置文件来启动本项目。
		 * http://eureka7001.com:7001/
		 */
		SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
	}
}
