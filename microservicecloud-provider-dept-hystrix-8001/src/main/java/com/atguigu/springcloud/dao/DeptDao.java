package com.atguigu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Dept;

/*
 * drop table springcloud_dept purge
create table springcloud_dept(
       deptno number(10),
       dname varchar2(50),
       db_source varchar2(50)
)
insert into springcloud_dept (deptno,dname, db_source) values (1,'01_aliyun_springcloud','dbsource01');
insert into springcloud_dept (deptno,dname, db_source) values (2,'02_aliyun_springcloud','dbsource01');
insert into springcloud_dept (deptno,dname, db_source) values (3,'03_aliyun_springcloud','dbsource01');

select deptno,dname,db_source from springcloud_dept where deptno='1';
 */
@Mapper
public interface DeptDao {
	public boolean addDept(Dept dept);
	public Dept findById(Long id);
	public List<Dept> findAll();
}
