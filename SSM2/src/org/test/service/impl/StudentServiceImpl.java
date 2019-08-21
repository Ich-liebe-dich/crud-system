package org.test.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.PageModel;
import org.test.entity.Student;
import org.test.mapper.StudentMapper;
import org.test.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.addStudent(student);
	}

	@Override
	public List<Student> queryStudentList() {
		// TODO Auto-generated method stub
		return studentMapper.queryStudentList();
	}
	

	public Student queryStudentById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.queryStudentById(id);
	}

	@Override
	public int updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}
	
	 @Override
	public List<Student> queryStudent(Student student){
	    return studentMapper.queryStudent(student);
	}
	 
	 public int count(Student student) {
		 return studentMapper.count(student);
	 }
	 
	 public List<Student> queryStudentListByPage(PageModel pageModel){
		 return studentMapper.queryStudentListByPage(pageModel);
	 }
	 
	 public List<Student> queryStudentByPage(HashMap<String, Object> map){
		 return studentMapper.queryStudentByPage(map);
	 }

	@Override
	public int deleteStuById(int id) {
		return studentMapper.deleteStuById(id);
	}

}
