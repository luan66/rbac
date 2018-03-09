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
	
	//��ѯ
	@PermissionAnnotation("�û���ѯ")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo")EmployeeQueryObject qo,Model model) {
		System.out.println(qo);
		List<Department> all = departmentService.getAll();
		model.addAttribute("depts", all);
		
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "employee/list";
	}
	//ɾ��
	@PermissionAnnotation("�û�ɾ��")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/employee/query.do";
	}
	//��ӻ�༭
	@PermissionAnnotation("�û����/�޸�")
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Employee employee,Long[] ids) {
		if(employee.getId() == null){
			service.save(employee,ids);
		}else{
			service.update(employee,ids);
		}
		return "redirect:/employee/query.do";
	}
	//��ת
	@RequestMapping("input")
	public String input(Long id,Model model) {
		//�Ȱ����еĽ�ɫ��ѯ����:
		List<Role> roles = roleService.getAll();
		System.out.println(roles);
		model.addAttribute("roles", roles);
		//��ѯ���еĲ��ŵ���Ϣ
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
