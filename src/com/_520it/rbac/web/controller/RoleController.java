package com._520it.rbac.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.rbac.annotation.PermissionAnnotation;
import com._520it.rbac.domain.Permission;
import com._520it.rbac.domain.Role;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IPermissionService;
import com._520it.rbac.service.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private IRoleService service;
	@Autowired
	private IPermissionService permissionService;
	//查询
	@PermissionAnnotation("角色查询")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo")QueryObject qo,Model model) {
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "role/list";
	}
	//删除
	@PermissionAnnotation("角色删除")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/role/query.do";
	}
	//添加或编辑
	@PermissionAnnotation("角色添加/修改")
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Role role,Long[] ids) {
		if(role.getId() == null){
			service.save(role,ids);
		}else{
			service.update(role,ids);
		}
		return "redirect:/role/query.do";
	}
	//跳转
	@RequestMapping("input")
	public String input(Long id,Model model){
		//1:先把所有的权限查询出来,共享到model中去:
		List<Permission> permissions = permissionService.getAll();
		model.addAttribute("permissions", permissions);
		if(id != null){
			Role role = service.get(id);
			model.addAttribute("entity", role);
		}
		return "role/input";
	}
	
}
