package org.test.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author DELL
 *
 */
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;    //>100000
    private String name;
    private String password;
    private String sex;
    private Integer age;
    private List<Course> courses;
    private Integer identity;
    
    public Student() {
    	setIdentity(2);
    }

	public Student(Integer id, String name, String sex, Integer age, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.courses = courses;
	}

	
	public Student(Integer id, String name, String password, String sex, Integer age, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.courses = courses;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
}
