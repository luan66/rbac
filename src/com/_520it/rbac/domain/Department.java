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
public class Department extends BaseDomain{
	private String name;	//部门名称;
	private String sn;		//部门编号;
}
