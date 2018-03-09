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
	private String keyword;		// �û���/����;
	private Integer deptId = -1;			// ����;
}
