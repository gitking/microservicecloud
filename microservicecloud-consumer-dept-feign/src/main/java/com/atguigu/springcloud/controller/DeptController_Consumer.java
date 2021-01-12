package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

/*
 * 注意我们这个工程是消费者工程,我们不需要有Service层,我们直接通过Feing面向接口DeptClientService调用生产者提供的服务就行。
 * Feign-Ribbon
 * 注意Feign继承了Ribbon,利用Ribbon维护了
 * MicroServiceCloud-Dept的服务列表信息,并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过Feign只需要定义服务绑定接口且以声明式的方法,优雅而简单的实现了服务调用。
 */
@RestController	
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id")Long id) {
		return this.service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}
	
	@RequestMapping(value="/consumer/dept/add")
	public Object add(Dept dept) {
		return this.service.add(dept);
	}
}
