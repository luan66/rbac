package com._520it.rbac.util;

import java.lang.reflect.Method;

public class ExpressionUtil {
	//私有化:单例
	private ExpressionUtil (){}
	//生成表达式方法:
	public static String getExpression(Method method) {
		String className = method.getDeclaringClass().getName();
		return className+":"+method.getName();
	}
}
