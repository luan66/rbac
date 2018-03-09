package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Permission;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;


public interface IPermissionService {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Permission entity);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 查询所有数据
	 * @param entity
	 */
	public List<Permission> getAll();
	/**
	 * 高级和分页查询:
	 * @return
	 */
	public PageResult query(QueryObject qo);
	/**
	 * 获取所有的权限中的表达式:
	 */
	public List<String> getExpression();
}
