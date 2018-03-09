package com._520it.rbac.web.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com._520it.rbac.annotation.PermissionAnnotation;
import com._520it.rbac.domain.Employee;
import com._520it.rbac.mapper.EmployeeMapper;
import com._520it.rbac.util.PermissionUtil;

//Ȩ�޷���������:
public class PermissionInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1:����ǳ���:ֱ�ӷ���;
		Employee employee = (Employee) request.getSession().getAttribute("emp_in_session");
		if (employee != null && employee.isAdmin()) {
			return true;
		}
		// 2:�жϷ�������û��ע��:û�о�ֱ�ӷ���;
		HandlerMethod hm = (HandlerMethod) handler;
		Method method = hm.getMethod();
		PermissionAnnotation anno = method.getAnnotation(PermissionAnnotation.class);
		if (anno == null) {
			return true;
		}
		// 3:û��:
		String expression = PermissionUtil.buildExpression(method);
		// 4:��ѯ��ǰ�û�������Ȩ��;
		List<String> expressions = mapper.getPermissionByEmployeeId(employee.getId());
		// 5:�ж��Ƿ�͵�ǰ�����ϵ�Ȩ����ͬ;
		if (expressions.contains(expression)) {
			return true;
		}
		// 6:��ͬ����,����ͬ�ص�������;
		request.getRequestDispatcher("/WEB-INF/views/common/nopermission.jsp").forward(request, response);
		return false;
	}
}
