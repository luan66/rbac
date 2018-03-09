package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Permission;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;


public interface IPermissionService {
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
	 * �߼��ͷ�ҳ��ѯ:
	 * @return
	 */
	public PageResult query(QueryObject qo);
	/**
	 * ��ȡ���е�Ȩ���еı��ʽ:
	 */
	public List<String> getExpression();
}
