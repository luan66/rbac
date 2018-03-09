package com._520it.rbac.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object object = request.getSession().getAttribute("emp_in_session");
		if(object != null){
			return true;
		}
		response.sendRedirect("/login.jsp");
		return false;
	}
}
