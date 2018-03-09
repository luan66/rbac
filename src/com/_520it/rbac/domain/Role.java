package com._520it.rbac.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门表:
 * @author mm
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseDomain{
	private String name;	//角色名称;
	private String sn;		//角色编号;
	
	//维护关系:角色与权限
	List<Permission> permissions = new ArrayList<>();
}
