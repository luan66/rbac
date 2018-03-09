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
	private String name;			//Ա������(��¼�˺�)
	private String password;		//Ա������;
	private String email;			//Ա���ʼ�;
	private Integer age;			//Ա������;
	private boolean admin;			//�Ƿ��ǳ�������Ա;
	private Department dept;		//��������;
	
	//������ϵ:�û��ͽ�ɫ�Ĺ�ϵ:
	List<Role> roles = new ArrayList<>();
}
