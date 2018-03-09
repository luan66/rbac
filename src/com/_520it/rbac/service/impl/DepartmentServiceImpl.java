package com._520it.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.rbac.domain.Department;
import com._520it.rbac.mapper.DepartmentMapper;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentMapper mapper;

	public void save(Department entity) {
		mapper.save(entity);
	}
	public void delete(Long id) {
		mapper.delete(id);
	}
	public void update(Department entity) {
		mapper.update(entity);
	}

	public Department get(Long id) {
		return mapper.get(id);
	}

	public List<Department> getAll() {
		return mapper.getAll();
	}
	
	public PageResult query(QueryObject qo) {
		//1:先判断是否有值:
		int totalCount = mapper.queryForCount(qo);
		if(totalCount == 0){
			return PageResult.PAGE_RESULT; 
		}
		//2:在获取值:
		List<Department> list = mapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(),list, totalCount);
	}
}
