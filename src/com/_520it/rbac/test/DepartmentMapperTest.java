package com._520it.rbac.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.rbac.domain.Department;
import com._520it.rbac.mapper.DepartmentMapper;
import com._520it.rbac.mapper.EmployeeMapper;
import com._520it.rbac.service.IDepartmentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class DepartmentMapperTest {
	@Autowired
	private DepartmentMapper mapper;
	@Autowired
	private IDepartmentService service;
	@Autowired
	private EmployeeMapper mapepr3;
	@Test
	public void testname() throws Exception {
//		System.out.println(mapepr2.getPermissionByRoleId(2L));
		System.out.println(mapepr3.get(4L).getRoles());
	}
	@Test
	public void testsave2() throws Exception {
		service.save(new Department("开发部", "1"));
	}
	@Test
	public void testSave() {
		mapper.save(new Department("开发部", "1"));
	}

	@Test
	public void testDelete() {
		mapper.delete(2L);
	}

	@Test
	public void testUpdate() {
		Department entity = new Department("销售部", "1");
		entity.setId(1L);
		mapper.update(entity);
	}

	@Test
	public void testGet() {
		System.out.println(mapper.get(1L));
	}

	@Test
	public void testGetAll() {
		List<Department> all = mapper.getAll();
		for (Department department : all) {
			System.out.println(department);
		}
	}

}
