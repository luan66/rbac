package com._520it.rbac.util;

import java.lang.reflect.Method;

public class ExpressionUtil {
	//˽�л�:����
	private ExpressionUtil (){}
	//���ɱ��ʽ����:
	public static String getExpression(Method method) {
		String className = method.getDeclaringClass().getName();
		return className+":"+method.getName();
	}
}
