package com._520it.rbac.util;

import java.lang.reflect.Method;

//�ϳɱ��ʽ�Ĺ�����:
public abstract class PermissionUtil {
	public static String buildExpression(Method method) {
		//ͨ��getDeclaringClass()������ȡ�����˷���������߽ӿ�:
		String className = method.getDeclaringClass().getName();
		return className + ":" + method.getName();
	}
}
