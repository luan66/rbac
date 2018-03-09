package com._520it.rbac.domain;

import java.util.ArrayList;
import java.util.List;

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
public class Employee extends BaseDomain{
	private String name;			//员工名称(登录账号)
	private String password;		//员工密码;
	private String email;			//员工邮件;
	private Integer age;			//员工年龄;
	private boolean admin;			//是否是超级管理员;
	private Department dept;		//所属部门;
	
	//建立关系:用户和角色的关系:
	List<Role> roles = new ArrayList<>();
}
