package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp {
	public static void main(String[] args) {
		/*
		 * microservicecloud-config-3344这个项目可以独立直接启动
		 * 启动成功之后,可以测试一下这个config微服务项目是否可以从Github上获取配置内容
		 * 启动成功之后,可以直接在浏览器上面访问以下地址:
		 * http://config-3344.com:3344/application-dev.yml
		 * http://config-3344.com:3344/application/dev/main
		 * http://config-3344.com:3344/main/application-dev.yml
		 */
		SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
	}
}
