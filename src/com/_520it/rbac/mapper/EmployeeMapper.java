package com._520it.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.query.EmployeeQueryObject;
public interface EmployeeMapper {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Employee entity);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * �޸�����
	 * @param entity
	 */
	public void update(Employee entity);
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
	 * �߼��ͷ�ҳ��ѯ����������:
	 * @param qo
	 */
	public int queryForCount(EmployeeQueryObject qo);
	/**
	 * �߼��ͷ�ҳ��ѯ�����ݼ���:
	 * @param qo
	 */
	public List<Employee> queryForList(EmployeeQueryObject qo);
	/**
	 * ά����ϵ:�û��ͽ�ɫ֮��Ĺ�ϵ:
	 * @param id
	 * @param id2
	 */
	public void insertRelation(@Param("employeeId")Long id, @Param("roleId")Long id2);
	/**
	 * �����û��ͽ�ɫ֮��Ĺ�ϵ:
	 * @param id
	 */
	public void deleteRelation(Long id);
	/**
	 * ��¼Ч��
	 * @param username
	 * @param password
	 */
	public Employee getLogin(@Param("username")String username, @Param("password")String password);
	
	/**
	 * ��ѯ��ǰ�û�������Ȩ��:
	 * @param id
	 */
	public List<String> getPermissionByEmployeeId(Long id);
}
