package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

/*
 * 注意我们这个工程是消费者工程,我们不需要有Service层,我们直接通过RestTemplate调用生产者提供的服务就行。
 */
@RestController	
public class DeptController_Consumer {
	
	/**
	 * 开启负载均衡之后就不能写死地址了http://localhost:8001,如果你每次都固定访问这个地址，那哪来的负载均衡。
	 */
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	/*
	 * 开启负载均衡之后要通过注册在Eureka上面的服务名去访问服务,不能写死地址
	 */
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumser/dept/add")
	public boolean add(Dept dept) {
		/*
		 * RestTemplate提供了多种便捷访问远程Http服务的方法,
		 * 是一种简单便捷的访问restful服务模板类,是Spring提供的用于访问Rest服务的客户端模板工具类,注意是客户端
		 * https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/javadoc-api/
		 * 使用RestTemplate访问restful接口非常的简单粗暴无脑
		 * (url,requestMap,ResponseBean.class)这三个参数分别代表Rest请求地址,请求参数,HTTP响应转换被转换成的对象类型。
		 */
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/consumser/dept/get/{id}")
	public Dept get(@PathVariable("id")Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")//压制警告
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	/*
	 * 注意我们这里调用的还是微服务生产者microservicecloud-provider-dept-8001提供的服务
	 * 消费端调用服务端的服务发现
	 */
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
