package org.test.entity;

import java.util.List;
/**
 * 
 * @author DELL
 *
 */
public class Teacher {
	
	private Integer id;    //教师编号
	private String name;    //姓名
	private String password;  //密码
	private String sex;    //性别
	private List<Course> courseList;    //所教课程
	Integer identity;
	
	public Teacher(Integer id, String name, String sex, List<Course> courseList) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.courseList = courseList;
	}

	public Teacher() {
		// TODO Auto-generated constructor stub
		id = -1;
		name = "";
		sex = "";
		courseList = null;
		identity = 1;
	}

	
	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
