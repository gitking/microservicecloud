package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*
 * 微服务一般都会要求实体类必须实现序列化接口
 */
//@AllArgsConstructor//让lombok帮我们自动生成带所有属性的构造方法
@NoArgsConstructor
@Data//自动生成getset方法
@Accessors(chain=true)//生成链式访问的格式
@SuppressWarnings("serial")//压制警告
public class Dept implements Serializable{
	private Long deptno;//部门主键
	private String dname;//部门名称
	private String db_source;//来自哪个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同数据库
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
	
	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.setDeptno(1l).setDb_source("01");
	}
	
}
