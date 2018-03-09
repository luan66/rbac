package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.EmployeeQueryObject;


public interface IEmployeeService {
	/**
	 * 添加一条数据
	 * @param entity
	 */
	public void save(Employee entity,Long[] ids);
	/**
	 * 删除一条数据
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * 修改数据
	 * @param entity
	 */
	public void update(Employee entity,Long[] ids);
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
	 * 高级和分页查询:
	 * @return
	 */
	public PageResult query(EmployeeQueryObject qo);
	/**
	 * 登陆效验:
	 * @param username
	 * @param password
	 */
	public Employee getLogin(String username, String password);
}
