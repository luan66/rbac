package com._520it.rbac.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.rbac.annotation.PermissionAnnotation;
import com._520it.rbac.domain.Department;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IDepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private IDepartmentService service;
	//��ѯ
	@PermissionAnnotation("���Ų�ѯ")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo")QueryObject qo,Model model) {
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "department/list";
	}
	//ɾ��
	@PermissionAnnotation("����ɾ��")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/department/query.do";
	}
	//��ӻ�༭
	@PermissionAnnotation("�������/�޸�")
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Department department) {
		if(department.getId() == null){
			service.save(department);
		}else{
			service.update(department);
		}
		return "redirect:/department/query.do";
	}
	//��ת
	@RequestMapping("input")
	public String input(Long id,Model model) {
		if(id != null){
			Department department = service.get(id);
			model.addAttribute("entity", department);
		}
		return "department/input";
	}
	
}
