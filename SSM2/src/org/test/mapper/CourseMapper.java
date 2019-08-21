package org.test.mapper;

import java.util.HashMap;
import java.util.List;

import org.test.entity.Course;
import org.test.entity.PageModel;

public interface CourseMapper {
	
	int addCourseById(HashMap<String,Integer> hashMap);
    
    int addCourseForTeacher(HashMap<String,Integer> hashMap);
    
    int addCourse(Course course);
    
    int deleteCourseById(int id);
    
    int updateCourse(Course course);
    
	Course queryCourseById(int id);
	
    List<Course> selectCourseByStuId(int id);
    
    List<Course> selectCourseByTeacherId(int id);
    
    List<Course> queryCourse(Course course);
    
    List<Course> queryCourseByPage(HashMap<String,Object> hashMap);

    List<Course> queryCourseListByPage(PageModel pageModel);
    
    Course selectCourseById(int id);
    
    List<Course> queryCourseList();
    
    int getCourseNum();
    
}
