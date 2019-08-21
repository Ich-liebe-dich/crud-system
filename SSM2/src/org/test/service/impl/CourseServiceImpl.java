package org.test.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.Course;
import org.test.entity.PageModel;
import org.test.mapper.CourseMapper;
import org.test.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;

	public void setCourseMapper(CourseMapper courseMapper) {
		this.courseMapper = courseMapper;
	}

	@Override
	public List<Course> selectCourseByStuId(int id) {
		return courseMapper.selectCourseByStuId(id);
	}

	@Override
	public List<Course> selectCourseByTeacherId(int id) {
		return courseMapper.selectCourseByTeacherId(id);
	}

	@Override
	public Course selectCourseById(int id) {
		return courseMapper.selectCourseById(id);
	}

	@Override
	public int addCourseById(HashMap<String, Integer> hashMap) {
		return courseMapper.addCourseById(hashMap);
	}

	@Override
	public int addCourseForTeacher(HashMap<String, Integer> hashMap) {
		return courseMapper.addCourseForTeacher(hashMap);
	}

	@Override
	public int addCourse(Course course) {
		return courseMapper.addCourse(course);
	}

	@Override
	public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
	}

	@Override
	public List<Course> queryCourseList() {
		return courseMapper.queryCourseList();
	}

	@Override
	public int getCourseNum() {
		return courseMapper.getCourseNum();
	}
	
	@Override
	public List<Course> queryCourse(Course course){
		return courseMapper.queryCourse(course);
	}

	@Override
	public List<Course> queryCourseByPage(HashMap<String, Object> hashMap) {
		return courseMapper.queryCourseByPage(hashMap);
	}

	@Override
	public List<Course> queryCourseListByPage(PageModel pageModel) {
		return courseMapper.queryCourseListByPage(pageModel);
	}

	@Override
	public Course queryCourseById(int id) {
		return courseMapper.queryCourseById(id);
	}

	@Override
	public int deleteCourseById(int id) {
		return courseMapper.deleteCourseById(id);
	}
	
	
}
