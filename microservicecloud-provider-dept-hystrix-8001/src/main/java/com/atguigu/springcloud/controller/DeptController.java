package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/get/{id}", method=RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息,会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
	/*
	 * 在microservicecloud-provider-dept-hystrix-8001这个工程里面使用@HystrixCommand这个注解不太好,
	 * 因为使用这个注解@HystrixCommand需要对每个方法都定义一个fallbackMethod,
	 * 并且我们这个工程的服务都是microservicecloud-api这个工程提供的,
	 * 所以可以把@HystrixCommand移动到microservicecloud-api这个工程里面去
	 */
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID:" + id + "没有对应的信息");
		}
		return dept;
	}
	public Dept processHystrix_Get(@PathVariable("id")Long id){
		return new Dept().setDeptno(id).setDname("该ID:" + id + "没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
	
	@RequestMapping(value="/dept/add", method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
	
	/*
	 * 需要使用@EnableDiscoveryClient
	 */
	@RequestMapping(value="/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();//得到eureka里面有多少个微服务
		System.out.println("***********" + list);
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");//根据服务实例名字得到指定的微服务信息
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" +
		element.getUri());
		}
		return this.client;
	}
}
