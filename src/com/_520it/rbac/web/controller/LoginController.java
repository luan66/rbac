package com._520it.rbac.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.rbac.domain.Employee;
import com._520it.rbac.service.IEmployeeService;

@Controller
public class LoginController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest req;
	
	@RequestMapping("get")
	public Employee get(Employee str) {
		return new Employee();
	}
	
	@RequestMapping("login")
	public String login(String username,String password) {
		try {
			Employee employee = service.getLogin(username,password);
			session.setAttribute("emp_in_session", employee);
		} catch (Exception e) {
			req.setAttribute("msg", e.getMessage());
			return "forward:/login.jsp";
		}
		return "redirect:/main.do";
	}
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
}
