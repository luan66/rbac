package com._520it.rbac.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeQueryObject extends QueryObject{
	private String keyword;		// 用户名/邮箱;
	private Integer deptId = -1;			// 部门;
}
