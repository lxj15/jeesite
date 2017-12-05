/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testc.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.testc.entity.SysClassinfo;

/**
 * 班级管理DAO接口
 * @author lxj
 * @version 2017-11-06
 */
@MyBatisDao
public interface SysClassinfoDao extends CrudDao<SysClassinfo> {
	
}