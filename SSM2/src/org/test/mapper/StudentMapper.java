package org.test.mapper;

import java.util.HashMap;
import java.util.List;

import org.test.entity.PageModel;
import org.test.entity.Student;


public interface StudentMapper {
	
    int addStudent(Student stduent);
    
    int updateStudent(Student student);
    
    Student queryStudentById(int id);
    
    List<Student> queryStudentList();
    
    List<Student> queryStudentListByPage(PageModel pageModel);
    
    List<Student> queryStudent(Student student);
    
    List<Student> queryStudentByPage(HashMap<String,Object> map);
    
    int count(Student student);
    
    int deleteStuById(int id);
    
}
