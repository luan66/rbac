package com._520it.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.rbac.domain.Role;
import com._520it.rbac.query.QueryObject;
public interface RoleMapper {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Role entity);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 修改数据
	 * @param entity
	 */
	public void update(Role entity);
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
	 * 高级和分页查询的总数据数:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * 高级和分页查询的数据集合:
	 * @param qo
	 */
	public List<Role> queryForList(QueryObject qo);
	/**
	 * 维护角色与权限的关系:
	 * @param id
	 * @param id2
	 */
	public void insertRelation(@Param("roleId")Long id, @Param("permissionId")Long id2);
	/**
	 * 删除中间表的数据:打破关系;
	 * @param id
	 */
	public void deleteRelation(Long roleId);
	/**
	 * 根据用户id.查询所有妈祖条件的数据:
	 * @param employeeId
	 * @return
	 */
	public List<Role> getRoleByEmployeeId(Long employeeId);
	
}
