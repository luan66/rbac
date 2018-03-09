package com._520it.rbac.web.controller;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.rbac.annotation.PermissionAnnotation;
import com._520it.rbac.domain.Permission;
import com._520it.rbac.page.PageResult;
import com._520it.rbac.query.QueryObject;
import com._520it.rbac.service.IPermissionService;
import com._520it.rbac.util.PermissionUtil;

@Controller
@RequestMapping("permission")
public class PermissionController {
	@Autowired
	private IPermissionService service;
	@Autowired
	private ApplicationContext applicationContext;

	// 查询
	@PermissionAnnotation("权限查询")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo") QueryObject qo, Model model) {
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "permission/list";
	}

	// 删除
	@PermissionAnnotation("权限删除")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/permission/query.do";
	}

	// 加载权限:
	@RequestMapping("reload")
	public String reload() {
		// 1:扫描所有的controller类:获取的是标有controller注解标签的类;
		Map<String, Object> ctls = applicationContext.getBeansWithAnnotation(Controller.class);
		Collection<Object> controllers = ctls.values();
		// 2:扫描所有的方法:
		for (Object controller : controllers) {
			Method[] methods = controller.getClass().getMethods();
			for (Method method : methods) {
				// 3:检查方法上有没有权限注解:
				PermissionAnnotation anno = method.getAnnotation(PermissionAnnotation.class);
				if (anno != null) {
					// 4:有:合成expression表达式;
					String expression = PermissionUtil.buildExpression(method);
					// 5:在保存之前,查询数据库中有没有已经存在了:
					List<String> exps = service.getExpression();
					if (exps != null && exps.contains(expression)) {
						continue;
					}
					//6:保存:
					Permission p = new Permission();
					p.setName(anno.value());
					p.setExpression(expression);
					service.save(p);
				}
			}
		}
		return "redirect:/permission/query.do";
	}
}
