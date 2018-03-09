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
		//ά����ϵ:
		for (Long id : ids) {
			mapper.insertRelation(entity.getId(),id);
		}
	}
	public void delete(Long id) {
		//1:�ȴ��ƹ�ϵ:
		mapper.deleteRelation(id);
		//2:��ɾ���û���Ϣ
		mapper.delete(id);
	}
	public void update(Role entity,Long[] ids) {
		//1:�Ȱ��м���е�����ɾ��:
		mapper.deleteRelation(entity.getId());
		//2:�޸�����
		mapper.update(entity);
		//3:�������Ȩ��:
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
		//1:���ж��Ƿ���ֵ:
		int totalCount = mapper.queryForCount(qo);
		if(totalCount == 0){
			return PageResult.PAGE_RESULT; 
		}
		//2:�ڻ�ȡֵ:
		List<Role> list = mapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(),list, totalCount);
	}
}
