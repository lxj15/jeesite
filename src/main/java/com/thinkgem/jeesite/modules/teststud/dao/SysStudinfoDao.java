/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teststud.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.teststud.entity.SysStudinfo;

/**
 * 学生管理DAO接口
 * @author lxj
 * @version 2017-11-06
 */
@MyBatisDao
public interface SysStudinfoDao extends CrudDao<SysStudinfo> {
	
}