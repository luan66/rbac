package com._520it.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.mapper.EmployeeMapper;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.EmployeeQueryObject;
import com._520it.rbac.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper mapper;

	public void save(Employee entity,Long[] ids) {
		mapper.save(entity);
		//维护关系:
		for (Long id : ids) {
			mapper.insertRelation(entity.getId(),id);
		}
	}
	public void delete(Long id) {
		mapper.delete(id);
	}
	public void update(Employee entity,Long[] ids) {
		//1:先打破关系:
		mapper.deleteRelation(entity.getId());
		//2:修改数据
		mapper.update(entity);
		//3:添加现有的角色关系:
		for (Long id : ids) {
			mapper.insertRelation(entity.getId(), id);
		}
	}

	public Employee get(Long id) {
		return mapper.get(id);
	}

	public List<Employee> getAll() {
		return mapper.getAll();
	}

	public PageResult query(EmployeeQueryObject qo) {
		int totalCount = mapper.queryForCount(qo);
		System.out.println(totalCount);
		if(totalCount == 0){
			return PageResult.PAGE_RESULT;
		}
		List<Employee> list = mapper.queryForList(qo);
		System.out.println(list);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(),list,totalCount);
	}
	
	@Override
	public Employee getLogin(String username, String password) {
		Employee em = mapper.getLogin(username, password);
		if(em == null){
			throw new RuntimeException("用户名或密码错误!");
		}
		return em;
	}

}
