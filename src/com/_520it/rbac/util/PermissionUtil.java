package com._520it.rbac.util;

import java.lang.reflect.Method;

//合成表达式的工具类:
public abstract class PermissionUtil {
	public static String buildExpression(Method method) {
		//通过getDeclaringClass()方法获取声明此方法的类或者接口:
		String className = method.getDeclaringClass().getName();
		return className + ":" + method.getName();
	}
}
