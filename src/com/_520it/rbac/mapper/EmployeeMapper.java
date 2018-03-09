package com._520it.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.query.EmployeeQueryObject;
public interface EmployeeMapper {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Employee entity);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 修改数据
	 * @param entity
	 */
	public void update(Employee entity);
	/**
	 * 查询一条数据
	 * @param entity
	 */
	public Employee get(Long id);
	/**
	 * 查询所有数据
	 * @param entity
	 */
	public List<Employee> getAll();
	/**
	 * 高级和分页查询的总数据数:
	 * @param qo
	 */
	public int queryForCount(EmployeeQueryObject qo);
	/**
	 * 高级和分页查询的数据集合:
	 * @param qo
	 */
	public List<Employee> queryForList(EmployeeQueryObject qo);
	/**
	 * 维护关系:用户和角色之间的关系:
	 * @param id
	 * @param id2
	 */
	public void insertRelation(@Param("employeeId")Long id, @Param("roleId")Long id2);
	/**
	 * 打破用户和角色之间的关系:
	 * @param id
	 */
	public void deleteRelation(Long id);
	/**
	 * 登录效验
	 * @param username
	 * @param password
	 */
	public Employee getLogin(@Param("username")String username, @Param("password")String password);
	
	/**
	 * 查询当前用户的所有权限:
	 * @param id
	 */
	public List<String> getPermissionByEmployeeId(Long id);
}
