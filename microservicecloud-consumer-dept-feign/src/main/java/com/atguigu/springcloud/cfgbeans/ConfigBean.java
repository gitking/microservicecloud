package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/*
 * 只要类上面加了@Configuration这个注解就说明这个类相当于之前的Spring的application.xml
 */
@Configuration
public class ConfigBean {
	
	/*
	 * RestTemplate提供了多种便捷访问远程Http服务的方法,
	 * 是一种简单便捷的访问restful服务模板类,是Spring提供的用于访问Rest服务的客户端模板工具类,注意是客户端
	 * https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/javadoc-api/
	 * 使用RestTemplate访问restful接口非常的简单粗暴无脑
	 * (url,requestMap,ResponseBean.class)这三个参数分别代表Rest请求地址,请求参数,HTTP响应转换被转换成的对象类型。
	 * 注意Ribbon是客户端的负载均衡,而我们microservicecloud-consumer-dept-80这个项目就是客户端项目,
	 * 客户端项目没有Service层，客户端项目就是通过RestTemplate调用服务端项目的服务,所以在引入Ribbon的pom之后要在
	 * RestTemplate上面开启@LoadBalanced负载均衡的功能。
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	/*
	 * 切换Ribbon的负载均衡算法,现在我指定Ribbon使用RoundRobinRule随机算法。
	 * 如果不指定Ribbon默认使用的是轮询负载均衡算法
	 */
	@Bean
	public IRule myRule() {
		return new RandomRule();//随机算法
	}
}
