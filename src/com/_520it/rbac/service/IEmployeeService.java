package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.EmployeeQueryObject;


public interface IEmployeeService {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Employee entity,Long[] ids);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * �޸�����
	 * @param entity
	 */
	public void update(Employee entity,Long[] ids);
	/**
	 * ��ѯһ������
	 * @param entity
	 */
	public Employee get(Long id);
	/**
	 * ��ѯ��������
	 * @param entity
	 */
	public List<Employee> getAll();
	/**
	 * �߼��ͷ�ҳ��ѯ:
	 * @return
	 */
	public PageResult query(EmployeeQueryObject qo);
	/**
	 * ��½Ч��:
	 * @param username
	 * @param password
	 */
	public Employee getLogin(String username, String password);
}
