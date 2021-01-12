package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		//return new RandomRule();
		return new RandomRule_ZY();//自定义为每台机器服务5次,5次之后按顺序让下一台服务器进行服务
	}
}
