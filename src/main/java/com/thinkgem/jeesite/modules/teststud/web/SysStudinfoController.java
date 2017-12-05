/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teststud.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.testc.entity.SysClassinfo;
import com.thinkgem.jeesite.modules.testc.service.SysClassinfoService;
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
import com.thinkgem.jeesite.modules.teststud.entity.SysStudinfo;
import com.thinkgem.jeesite.modules.teststud.service.SysStudinfoService;

import java.util.List;

/**
 * 学生管理Controller
 * @author lxj
 * @version 2017-11-06
 */
@Controller
@RequestMapping(value = "${adminPath}/teststud/sysStudinfo")
public class SysStudinfoController extends BaseController {

	@Autowired
	private SysStudinfoService sysStudinfoService;

	@Autowired
	private SysClassinfoService sysClassinfoService;

	@ModelAttribute
	public SysStudinfo get(@RequestParam(required=false) String id) {
		SysStudinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysStudinfoService.get(id);
		}
		if (entity == null){
			entity = new SysStudinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("teststud:sysStudinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysStudinfo sysStudinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysStudinfo> page = sysStudinfoService.findPage(new Page<SysStudinfo>(request, response), sysStudinfo); 
		model.addAttribute("page", page);
		return "modules/teststud/sysStudinfoList";
	}

	@RequiresPermissions("teststud:sysStudinfo:view")
	@RequestMapping(value = "form")
	public String form(SysStudinfo sysStudinfo, Model model) {
		SysClassinfo sysClassinfo=new SysClassinfo();
		List<SysClassinfo> Classes= sysClassinfoService.findList(sysClassinfo);
		model.addAttribute("Classes", Classes);
		model.addAttribute("sysStudinfo", sysStudinfo);
		return "modules/teststud/sysStudinfoForm";
	}

	@RequiresPermissions("teststud:sysStudinfo:edit")
	@RequestMapping(value = "save")
	public String save(SysStudinfo sysStudinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysStudinfo)){
			return form(sysStudinfo, model);
		}
		sysStudinfoService.save(sysStudinfo);
		addMessage(redirectAttributes, "保存学生管理成功");
		return "redirect:"+Global.getAdminPath()+"/teststud/sysStudinfo/?repage";
	}
	
	@RequiresPermissions("teststud:sysStudinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(SysStudinfo sysStudinfo, RedirectAttributes redirectAttributes) {
		sysStudinfoService.delete(sysStudinfo);
		addMessage(redirectAttributes, "删除学生管理成功");
		return "redirect:"+Global.getAdminPath()+"/teststud/sysStudinfo/?repage";
	}

}