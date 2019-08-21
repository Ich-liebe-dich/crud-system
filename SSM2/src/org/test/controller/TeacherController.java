package org.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.entity.PageModel;
import org.test.entity.Teacher;
import org.test.service.impl.TeacherServiceImpl;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	@Qualifier("teacherService")
    private TeacherServiceImpl teacherService;	
	
	/**
	 * 获取教师列表，分页返回
	 * @param pageIndex
	 * @param map
	 * @return
	 */
	@RequestMapping("selectTeacher/{pageIndex}")
	public String teacherInfos(@PathVariable("pageIndex")Integer pageIndex,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(teacherService.count(new Teacher()));
		List<Teacher> list = teacherService.queryTeacherListByPage(pageModel);
		map.put("teacherList", list);
		map.put("page", pageModel);
		return "teacher/showSelectTeacher";
	}	
	
	/**
	 * 增加教师
	 * @param flag flag为1的时候跳转到增加页面，否则进行增加操作
	 * @param teacher
	 * @param map
	 * @return
	 */
	@RequestMapping("addTeacher")
	public String teacherInfo(String flag,
			 @ModelAttribute Teacher teacher, Map<String,Object> map) {
		if("1".equals(flag)) {
			return "teacher/showAddTeacher";
		}else {
			teacherService.addTeacher(teacher);
			return "redirect:/teacher/selectTeacher/1";
		}
	}
	
	/**
	 * 批量删除教师
	 * @param ids
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteTeacher")
	public String deleteTeacher(String ids,
			Map<String,Object> map) {
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除员工
			teacherService.deleteTeacherById(Integer.parseInt(id));
		}
		return "redirect:/teacher/selectTeacher/1";
	}
	
	/**
	 * 跳转到更新教师的界面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("updateTeacher")
	public String showUpdateTeacher(@RequestParam("id")Integer id,
			Map<String,Object> map) {
		Teacher teacher = teacherService.queryTeacherById(id);
		map.put("teacher", teacher);
		return "teacher/showUpdateTeacher";
	}
	
	/**
	 * 进行更新操作
	 * @param teacher
	 * @param map
	 * @return
	 */
	@RequestMapping("updateTeacher/update")
	public String updateTeacher(@ModelAttribute Teacher teacher,
			Map<String,Object> map) {
		teacherService.updateTeacher(teacher);
		return "redirect:/teacher/selectTeacher/1";
	}
    
	/**
	 * 根据不同条件查询教师，分页返回
	 * @param pageIndex
	 * @param teacher
	 * @param map
	 * @return
	 */
	@RequestMapping("queryTeacher/{pageIndex}")
	public String queryTeacher(@PathVariable("pageIndex")Integer pageIndex,@ModelAttribute Teacher teacher,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		HashMap<String,Object> hashMap = new HashMap<>();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(teacherService.count(teacher));
		hashMap.put("teacher",teacher);
		hashMap.put("page", pageModel);
		List<Teacher> list = teacherService.queryTeacherByPage(hashMap);
		map.put("page", pageModel);
		map.put("queryTeacher",teacher);
		map.put("teacherList",list);
		return "teacher/showQueryTeacher";
	}
}
