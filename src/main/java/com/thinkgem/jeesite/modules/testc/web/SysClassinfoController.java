/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.testc.entity.SysClassinfo;
import com.thinkgem.jeesite.modules.testc.service.SysClassinfoService;

/**
 * 班级管理Controller
 * @author lxj
 * @version 2017-11-06
 */
@Controller
@RequestMapping(value = "${adminPath}/testc/sysClassinfo")
public class SysClassinfoController extends BaseController {

	@Autowired
	private SysClassinfoService sysClassinfoService;
	
	@ModelAttribute
	public SysClassinfo get(@RequestParam(required=false) String id) {
		SysClassinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysClassinfoService.get(id);
		}
		if (entity == null){
			entity = new SysClassinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("testc:sysClassinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysClassinfo sysClassinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysClassinfo> page = sysClassinfoService.findPage(new Page<SysClassinfo>(request, response), sysClassinfo); 
		model.addAttribute("page", page);
		return "modules/testc/sysClassinfoList";
	}

	@RequiresPermissions("testc:sysClassinfo:view")
	@RequestMapping(value = "form")
	public String form(SysClassinfo sysClassinfo, Model model) {
		model.addAttribute("sysClassinfo", sysClassinfo);
		return "modules/testc/sysClassinfoForm";
	}

	@RequiresPermissions("testc:sysClassinfo:edit")
	@RequestMapping(value = "save")
	public String save(SysClassinfo sysClassinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysClassinfo)){
			return form(sysClassinfo, model);
		}
		sysClassinfoService.save(sysClassinfo);
		addMessage(redirectAttributes, "保存班级管理成功");
		return "redirect:"+Global.getAdminPath()+"/testc/sysClassinfo/?repage";
	}
	
	@RequiresPermissions("testc:sysClassinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(SysClassinfo sysClassinfo, RedirectAttributes redirectAttributes) {
		sysClassinfoService.delete(sysClassinfo);
		addMessage(redirectAttributes, "删除班级管理成功");
		return "redirect:"+Global.getAdminPath()+"/testc/sysClassinfo/?repage";
	}

}