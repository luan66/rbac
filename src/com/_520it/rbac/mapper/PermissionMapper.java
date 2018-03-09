package com._520it.rbac.mapper;

import java.util.List;

import com._520it.rbac.domain.Permission;
import com._520it.rbac.query.QueryObject;
public interface PermissionMapper {
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
	 * 高级和分页查询的总数据数:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * 高级和分页查询的数据集合:
	 * @param qo
	 */
	public List<Permission> queryForList(QueryObject qo);
	/**
	 * 获取所有的权限中的表达式:
	 */
	public List<String> getExpression();
	/**
	 * 根据角色id去权限对象:
	 */
	public List<Permission> getPermissionByRoleId(Long id);
}
