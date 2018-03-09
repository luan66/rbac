package com._520it.rbac.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.rbac.mapper.DepartmentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class TestSqlSession {
	@Autowired
	private SqlSessionFactory factory;
	@Autowired
	private DepartmentMapper mapper;
	@Test
	public void testname() throws Exception {
		System.out.println(factory);
		System.out.println(mapper.getClass());
	}
	@Test
	public void testname2() throws Exception {
		int[] arr = new int[]{1,2};
		System.out.println(arr);
		
	}
}
