package com._520it.rbac.mapper;

import java.util.List;

import com._520it.rbac.domain.Department;
import com._520it.rbac.query.QueryObject;
public interface DepartmentMapper {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Department entity);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 修改数据
	 * @param entity
	 */
	public void update(Department entity);
	/**
	 * 查询一条数据
	 * @param entity
	 */
	public Department get(Long id);
	/**
	 * 查询所有数据
	 * @param entity
	 */
	public List<Department> getAll();
	/**
	 * 高级和分页查询的总数据数:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * 高级和分页查询的数据集合:
	 * @param qo
	 */
	public List<Department> queryForList(QueryObject qo);
}
