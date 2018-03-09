package com._520it.rbac.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ���ű�:
 * @author mm
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseDomain{
	private String name;	//��ɫ����;
	private String sn;		//��ɫ���;
	
	//ά����ϵ:��ɫ��Ȩ��
	List<Permission> permissions = new ArrayList<>();
}
