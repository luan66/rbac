package com._520it.rbac.domain;

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
public class Permission extends BaseDomain{
	private String name;		//Ȩ������;
	private String expression;	//Ȩ�ޱ��ʽ(ͨ�����ȥƥ��Ȩ��);
}
