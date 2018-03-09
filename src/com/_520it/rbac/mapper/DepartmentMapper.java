package com._520it.rbac.mapper;

import java.util.List;

import com._520it.rbac.domain.Department;
import com._520it.rbac.query.QueryObject;
public interface DepartmentMapper {
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
	 * �߼��ͷ�ҳ��ѯ����������:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * �߼��ͷ�ҳ��ѯ�����ݼ���:
	 * @param qo
	 */
	public List<Department> queryForList(QueryObject qo);
}
