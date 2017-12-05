/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teststud.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生管理Entity
 * @author lxj
 * @version 2017-11-06
 */
public class SysStudinfo extends DataEntity<SysStudinfo> {
	
	private static final long serialVersionUID = 1L;
	private String studNum;		// 学生学号
	private String studName;		// 学生姓名
	private String ClassNum;		// 班级编号
	
	public SysStudinfo() {
		super();
	}

	public SysStudinfo(String id){
		super(id);
	}

	@Length(min=0, max=255, message="学生学号长度必须介于 0 和 255 之间")
	public String getStudNum() {
		return studNum;
	}

	public void setStudNum(String studNum) {
		this.studNum = studNum;
	}
	
	@Length(min=0, max=255, message="学生姓名长度必须介于 0 和 255 之间")
	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	@Length(min=0, max=255, message="班级编号长度必须介于 0 和 255 之间")
	public String getClassNum() {
		return ClassNum;
	}

	public void setClassNum(String ClassNum) {
		this.ClassNum = ClassNum;
	}
	
}