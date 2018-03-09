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

//权限访问拦截器:
public class PermissionInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1:如果是超管:直接放行;
		Employee employee = (Employee) request.getSession().getAttribute("emp_in_session");
		if (employee != null && employee.isAdmin()) {
			return true;
		}
		// 2:判断方法上有没有注解:没有就直接放行;
		HandlerMethod hm = (HandlerMethod) handler;
		Method method = hm.getMethod();
		PermissionAnnotation anno = method.getAnnotation(PermissionAnnotation.class);
		if (anno == null) {
			return true;
		}
		// 3:没有:
		String expression = PermissionUtil.buildExpression(method);
		// 4:查询当前用户的所有权限;
		List<String> expressions = mapper.getPermissionByEmployeeId(employee.getId());
		// 5:判断是否和当前方法上的权限相同;
		if (expressions.contains(expression)) {
			return true;
		}
		// 6:相同放行,不相同回到主界面;
		request.getRequestDispatcher("/WEB-INF/views/common/nopermission.jsp").forward(request, response);
		return false;
	}
}
