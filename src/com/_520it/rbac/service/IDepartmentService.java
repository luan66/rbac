package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Department;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;


public interface IDepartmentService {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Department entity);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * �޸�����
	 * @param entity
	 */
	public void update(Department entity);
	/**
	 * ��ѯһ������
	 * @param entity
	 */
	public Department get(Long id);
	/**
	 * ��ѯ��������
	 * @param entity
	 */
	public List<Department> getAll();
	/**
	 * �߼��ͷ�ҳ��ѯ:
	 * @return
	 */
	public PageResult query(QueryObject qo);
}
