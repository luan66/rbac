package com._520it.rbac.service;

import java.util.List;

import com._520it.rbac.domain.Role;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;


public interface IRoleService {
	/**
	 * ���һ������
	 * @param entity
	 */
	public void save(Role entity,Long[] ids);
	/**
	 * ɾ��һ������
	 * @param entity
	 */
	public void delete(Long id);
	/**
	 * �޸�����
	 * @param entity
	 */
	public void update(Role entity,Long[] ids);
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
	 * �߼��ͷ�ҳ��ѯ:
	 * @return
	 */
	public PageResult query(QueryObject qo);
}
