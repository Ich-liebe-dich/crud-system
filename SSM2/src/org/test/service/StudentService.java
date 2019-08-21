package org.test.service;

import java.util.HashMap;
import java.util.List;

import org.test.entity.PageModel;
import org.test.entity.Student;


public interface StudentService {
	
	/**
	 * Student:id name sex age
	 * @param student
	 */
    int addStudent(Student student);
    
    int updateStudent(Student student);
    
    List<Student> queryStudentList();
    
    Student queryStudentById(int id);
    
    List<Student> queryStudent(Student student);
    
    List<Student> queryStudentByPage(HashMap<String,Object> map);
    
    List<Student> queryStudentListByPage(PageModel pageModel);
    
    int count(Student student);
    
    int deleteStuById(int id);
}
