/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teststud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.teststud.entity.SysStudinfo;
import com.thinkgem.jeesite.modules.teststud.dao.SysStudinfoDao;

/**
 * 学生管理Service
 * @author lxj
 * @version 2017-11-06
 */
@Service
@Transactional(readOnly = true)
public class SysStudinfoService extends CrudService<SysStudinfoDao, SysStudinfo> {

	public SysStudinfo get(String id) {
		return super.get(id);
	}
	
	public List<SysStudinfo> findList(SysStudinfo sysStudinfo) {
		return super.findList(sysStudinfo);
	}
	
	public Page<SysStudinfo> findPage(Page<SysStudinfo> page, SysStudinfo sysStudinfo) {
		return super.findPage(page, sysStudinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(SysStudinfo sysStudinfo) {
		super.save(sysStudinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysStudinfo sysStudinfo) {
		super.delete(sysStudinfo);
	}
	
}