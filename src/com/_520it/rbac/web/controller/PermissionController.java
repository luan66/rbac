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

	// ��ѯ
	@PermissionAnnotation("Ȩ�޲�ѯ")
	@RequestMapping("query")
	public String list(@ModelAttribute("qo") QueryObject qo, Model model) {
		PageResult result = service.query(qo);
		model.addAttribute("result", result);
		return "permission/list";
	}

	// ɾ��
	@PermissionAnnotation("Ȩ��ɾ��")
	@RequestMapping("delete")
	public String delete(Long id) {
		service.delete(id);
		return "redirect:/permission/query.do";
	}

	// ����Ȩ��:
	@RequestMapping("reload")
	public String reload() {
		// 1:ɨ�����е�controller��:��ȡ���Ǳ���controllerע���ǩ����;
		Map<String, Object> ctls = applicationContext.getBeansWithAnnotation(Controller.class);
		Collection<Object> controllers = ctls.values();
		// 2:ɨ�����еķ���:
		for (Object controller : controllers) {
			Method[] methods = controller.getClass().getMethods();
			for (Method method : methods) {
				// 3:��鷽������û��Ȩ��ע��:
				PermissionAnnotation anno = method.getAnnotation(PermissionAnnotation.class);
				if (anno != null) {
					// 4:��:�ϳ�expression���ʽ;
					String expression = PermissionUtil.buildExpression(method);
					// 5:�ڱ���֮ǰ,��ѯ���ݿ�����û���Ѿ�������:
					List<String> exps = service.getExpression();
					if (exps != null && exps.contains(expression)) {
						continue;
					}
					//6:����:
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
