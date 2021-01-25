package com.arguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClient_3355_StartSpringCloudApp {
	public static void main(String[] args) {
		/*
		 * 一定要先启动microservicecloud-config-3344这个项目,因为我们这个microservicecloud-config-client-3355项目启动的时候
		 * 会去请求microservicecloud-config-3344这个项目,通过microservicecloud-config-3344这个项目去访问github上面的yml配置文件
		 * 再根据获取到的配置文件来启动本项目。
		 * http://client-config.com:8202/config
		 */
		SpringApplication.run(ConfigClient_3355_StartSpringCloudApp.class, args);
	}
}
