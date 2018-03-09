package com._520it.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.rbac.domain.Role;
import com._520it.rbac.mapper.RoleMapper;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper mapper;

	public void save(Role entity,Long[] ids) {
		mapper.save(entity);
		//维护关系:
		for (Long id : ids) {
			mapper.insertRelation(entity.getId(),id);
		}
	}
	public void delete(Long id) {
		//1:先打破关系:
		mapper.deleteRelation(id);
		//2:再删除用户信息
		mapper.delete(id);
	}
	public void update(Role entity,Long[] ids) {
		//1:先把中间表中的数据删除:
		mapper.deleteRelation(entity.getId());
		//2:修改数据
		mapper.update(entity);
		//3:添加现有权限:
		for (Long id : ids) {
			mapper.insertRelation(entity.getId(), id);
		}
	}

	public Role get(Long id) {
		return mapper.get(id);
	}

	public List<Role> getAll() {
		return mapper.getAll();
	}
	
	public PageResult query(QueryObject qo) {
		//1:先判断是否有值:
		int totalCount = mapper.queryForCount(qo);
		if(totalCount == 0){
			return PageResult.PAGE_RESULT; 
		}
		//2:在获取值:
		List<Role> list = mapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(),list, totalCount);
	}
}
