package com._520it.rbac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.rbac.domain.Role;
import com._520it.rbac.query.QueryObject;
public interface RoleMapper {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Role entity);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * �޸�����
	 * @param entity
	 */
	public void update(Role entity);
	/**
	 * ��ѯһ������
	 * @param entity
	 */
	public Role get(Long id);
	/**
	 * ��ѯ��������
	 * @param entity
	 */
	public List<Role> getAll();
	/**
	 * �߼��ͷ�ҳ��ѯ����������:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * �߼��ͷ�ҳ��ѯ�����ݼ���:
	 * @param qo
	 */
	public List<Role> queryForList(QueryObject qo);
	/**
	 * ά����ɫ��Ȩ�޵Ĺ�ϵ:
	 * @param id
	 * @param id2
	 */
	public void insertRelation(@Param("roleId")Long id, @Param("permissionId")Long id2);
	/**
	 * ɾ���м�������:���ƹ�ϵ;
	 * @param id
	 */
	public void deleteRelation(Long roleId);
	/**
	 * �����û�id.��ѯ������������������:
	 * @param employeeId
	 * @return
	 */
	public List<Role> getRoleByEmployeeId(Long employeeId);
	
}
