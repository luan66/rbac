package com._520it.rbac.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.rbac.annotation.PermissionAnnotation;
import com._520it.rbac.domain.Department;
import com._520it.rbac.domain.Employee;
import com._520it.rbac.domain.Role;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.EmployeeQueryObject;
import com._520it.rbac.service.IDepartmentService;
import com._520it.rbac.service.IEmployeeService;
import com._520it.rbac.service.IRoleService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IRoleService roleService;
	
	//查询
	@PermissionAnnotation("用户查询")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo")EmployeeQueryObject qo,Model model) {
		System.out.println(qo);
		List<Department> all = departmentService.getAll();
		model.addAttribute("depts", all);
		
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "employee/list";
	}
	//删除
	@PermissionAnnotation("用户删除")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/employee/query.do";
	}
	//添加或编辑
	@PermissionAnnotation("用户添加/修改")
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Employee employee,Long[] ids) {
		if(employee.getId() == null){
			service.save(employee,ids);
		}else{
			service.update(employee,ids);
		}
		return "redirect:/employee/query.do";
	}
	//跳转
	@RequestMapping("input")
	public String input(Long id,Model model) {
		//先把所有的角色查询查来:
		List<Role> roles = roleService.getAll();
		System.out.println(roles);
		model.addAttribute("roles", roles);
		//查询所有的部门的信息
		List<Department> all = departmentService.getAll();
		model.addAttribute("depts", all);
		System.out.println(all);
		if(id != null){
			Employee employee = service.get(id);
			System.out.println(employee.getRoles());
			model.addAttribute("entity", employee);
		}
		return "employee/input";
	}
	
}
