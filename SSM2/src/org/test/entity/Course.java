package org.test.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author DELL
 *
 */
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;    //学号
	private String name;    //姓名
	private Integer hour;    //学时
	private Double credit;   //学分
	private String desc;  //描述
	private String remark;    //备注
	private Teacher teacher;    //教师
	private List<Student> stuList;  //学生列表
	private Integer capacity;    //容量
	
    public Course(){
    	
    }
    
	public Course(Integer id, String name, Integer hour, Double credit, String desc, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.credit = credit;
		this.desc = desc;
		this.remark = remark;
	}



	public Course(Integer id, String name, Integer hour, Double credit, String desc, String remark, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.credit = credit;
		this.desc = desc;
		this.remark = remark;
		this.capacity = capacity;
	}

	public Course(Integer id, String name, Integer hour, Double credit, String desc, Teacher teacher, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.credit = credit;
		this.desc = desc;
		this.teacher = teacher;
		this.capacity = capacity;
	}

	public Course(Integer id, String name, Integer hour, Double credit, String desc, String remark, Teacher teacher,
			List<Student> stuList, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.credit = credit;
		this.desc = desc;
		this.remark = remark;
		this.teacher = teacher;
		this.stuList = stuList;
		this.capacity = capacity;
	}



	public Integer getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Integer getHour() {
		return hour;
	}



	public Double getCredit() {
		return credit;
	}



	public String getDesc() {
		return desc;
	}



	public String getRemark() {
		return remark;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public List<Student> getStuList() {
		return stuList;
	}



	public Integer getCapacity() {
		return capacity;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setHour(Integer hour) {
		this.hour = hour;
	}



	public void setCredit(Double credit) {
		this.credit = credit;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}



	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
}
