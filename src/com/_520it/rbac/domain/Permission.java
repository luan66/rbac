package com._520it.rbac.domain;

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
public class Permission extends BaseDomain{
	private String name;		//权限名称;
	private String expression;	//权限表达式(通过这个去匹配权限);
}
