/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testc.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班级管理Entity
 * @author lxj
 * @version 2017-11-06
 */
public class SysClassinfo extends DataEntity<SysClassinfo> {
	
	private static final long serialVersionUID = 1L;
	private String classNum;		// 班级编号
	private String className;		// 班级名字
	
	public SysClassinfo() {
		super();
	}

	public SysClassinfo(String id){
		super(id);
	}

	@Length(min=0, max=255, message="班级编号长度必须介于 0 和 255 之间")
	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	@Length(min=0, max=255, message="班级名字长度必须介于 0 和 255 之间")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}