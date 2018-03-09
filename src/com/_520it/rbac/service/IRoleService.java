package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Role;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;


public interface IRoleService {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Role entity,Long[] ids);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 修改数据
	 * @param entity
	 */
	public void update(Role entity,Long[] ids);
	/**
	 * 查询一条数据
	 * @param entity
	 */
	public Role get(Long id);
	/**
	 * 查询所有数据
	 * @param entity
	 */
	public List<Role> getAll();
	/**
	 * 高级和分页查询:
	 * @return
	 */
	public PageResult query(QueryObject qo);
}
