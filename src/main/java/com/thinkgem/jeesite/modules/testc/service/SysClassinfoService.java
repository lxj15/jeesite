/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.testc.entity.SysClassinfo;
import com.thinkgem.jeesite.modules.testc.dao.SysClassinfoDao;

/**
 * 班级管理Service
 * @author lxj
 * @version 2017-11-06
 */
@Service
@Transactional(readOnly = true)
public class SysClassinfoService extends CrudService<SysClassinfoDao, SysClassinfo> {

	public SysClassinfo get(String id) {
		return super.get(id);
	}
	
	public List<SysClassinfo> findList(SysClassinfo sysClassinfo) {
		return super.findList(sysClassinfo);
	}
	
	public Page<SysClassinfo> findPage(Page<SysClassinfo> page, SysClassinfo sysClassinfo) {
		return super.findPage(page, sysClassinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(SysClassinfo sysClassinfo) {
		super.save(sysClassinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysClassinfo sysClassinfo) {
		super.delete(sysClassinfo);
	}
	
}