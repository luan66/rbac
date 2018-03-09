package com._520it.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.rbac.domain.Permission;
import com._520it.rbac.mapper.PermissionMapper;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IPermissionService;
@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper mapper;

	public void save(Permission entity) {
		mapper.save(entity);
	}
	public void delete(Long id) {
		mapper.delete(id);
	}

	public List<Permission> getAll() {
		return mapper.getAll();
	}
	
	public PageResult query(QueryObject qo) {
		//1:先判断是否有值:
		int totalCount = mapper.queryForCount(qo);
		if(totalCount == 0){
			return PageResult.PAGE_RESULT; 
		}
		//2:在获取值:
		List<Permission> list = mapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(),list, totalCount);
	}
	@Override
	public List<String> getExpression() {
		mapper.getExpression();
		return null;
	}
}
