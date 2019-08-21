package org.test.mapper;

import java.util.HashMap;
import java.util.List;

import org.test.entity.PageModel;
import org.test.entity.Teacher;

public interface TeacherMapper {
	
    List<Teacher> queryTeacher(Teacher teacher);
    
    List<Teacher> queryTeacherByPage(HashMap<String,Object> hashMap);
    
    Teacher queryTeacherById(int id);
    
    List<Teacher> queryTeacherList();
    
    List<Teacher> queryTeacherListByPage(PageModel pageModel);
    
    int addTeacher(Teacher teacher);
    
    int updateTeacher(Teacher teacher);
    
    int count(Teacher teacher);
    
    int deleteTeacherById(int id);
}
