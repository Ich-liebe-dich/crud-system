package org.test.entity;

public class Admin {
	
	private Integer id;      //10000 < id < 20000
	private String name;     //姓名
	private String password; //密码
	private String sex;      //性别
	private Integer age;     //年龄
	private Integer identity;//身份，默认为0,admin
	
	public Admin() {
		identity = 0;
	}
	
	public Admin(Integer id, String name, String password, String sex, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
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

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	
}
