package org.test.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.PageModel;
import org.test.entity.Teacher;
import org.test.mapper.TeacherMapper;
import org.test.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherMapper teacherMapper;

	public void setTacherMapper(TeacherMapper tacherMapper) {
		this.teacherMapper = tacherMapper;
	}

	

	@Override
	public Teacher queryTeacherById(int id) {
		return teacherMapper.queryTeacherById(id);
	}

	@Override
	public int addTeacher(Teacher teacher) {
		return teacherMapper.addTeacher(teacher);
	}


	@Override
	public int updateTeacher(Teacher teacher) {
		return teacherMapper.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> queryTeacherList() {
		return teacherMapper.queryTeacherList();
	}



	@Override
	public List<Teacher> queryTeacher(Teacher teacher) {
		return teacherMapper.queryTeacher(teacher);
	}



	@Override
	public List<Teacher> queryTeacherByPage(HashMap<String, Object> hashMap) {
		return teacherMapper.queryTeacherByPage(hashMap);
	}





	@Override
	public int count(Teacher teacher) {
		return teacherMapper.count(teacher);
	}



	@Override
	public List<Teacher> queryTeacherListByPage(PageModel pageModel) {
		return teacherMapper.queryTeacherListByPage(pageModel);
	}



	@Override
	public int deleteTeacherById(int id) {
		return teacherMapper.deleteTeacherById(id);
	}
	
	
	
}
