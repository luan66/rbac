package com._520it.rbac.mapper;

import java.util.List;

import com._520it.rbac.domain.Permission;
import com._520it.rbac.query.QueryObject;
public interface PermissionMapper {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Permission entity);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * ��ѯ��������
	 * @param entity
	 */
	public List<Permission> getAll();
	/**
	 * �߼��ͷ�ҳ��ѯ����������:
	 * @param qo
	 */
	public int queryForCount(QueryObject qo);
	/**
	 * �߼��ͷ�ҳ��ѯ�����ݼ���:
	 * @param qo
	 */
	public List<Permission> queryForList(QueryObject qo);
	/**
	 * ��ȡ���е�Ȩ���еı��ʽ:
	 */
	public List<String> getExpression();
	/**
	 * ���ݽ�ɫidȥȨ�޶���:
	 */
	public List<Permission> getPermissionByRoleId(Long id);
}
