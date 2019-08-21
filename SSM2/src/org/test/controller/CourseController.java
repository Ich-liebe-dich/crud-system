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
import org.test.entity.Course;
import org.test.entity.PageModel;
import org.test.service.impl.CourseServiceImpl;

@Controller
@RequestMapping("course")
public class CourseController {

	@Autowired
	@Qualifier("courseService")
	private CourseServiceImpl courseService;

	public void setCourseService(CourseServiceImpl courseService) {
		this.courseService = courseService;
	}
	
	/**
	 * 分页返回课程列表
	 * @param pageIndex
	 * @param map
	 * @return
	 */
	@RequestMapping("selectCourse/{pageIndex}")
	public String courseInfos(@PathVariable("pageIndex")Integer pageIndex,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(courseService.getCourseNum());
		List<Course> courseList = courseService.queryCourseListByPage(pageModel);
		map.put("page", pageModel);
		map.put("courseList", courseList);
		return "course/showSelectCourse";
	}
	
	/**
	 * 增加课程
	 * @param flag
	 * @param course
	 * @param map
	 * @return
	 */
	@RequestMapping("addCourse")
	public String courseInfo(String flag,
			 @ModelAttribute Course course,Map<String,Object> map) {
		if("1".equals(flag)) {
			return "course/showAddCourse";
		}else {
			courseService.addCourse(course);
			return "redirect:/course/selectCourse/1";
		}
		
	}
	
	/**
	 * 删除课程
	 * @param ids
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteCourse")
	public String deleteCourse(String ids,
			Map<String,Object> map) {
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除员工
			courseService.deleteCourseById(Integer.parseInt(id));
		}
		return "redirect:/course/selectCourse/1";
	}
	
	/**
	 * 跳转到更新课程的页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("updateCourse")
	public String showUpdateCourse(@RequestParam("id")Integer id,
			Map<String,Object> map) {
		Course course = courseService.queryCourseById(id);
		map.put("course", course);
		return "course/showUpdateCourse";
	}
	
	/**
	 * 实行更新课程操作
	 * @param course
	 * @param map
	 * @return
	 */
	@RequestMapping("updateCourse/update")
	public String updateCourse(@ModelAttribute Course course,
			Map<String,Object> map) {
		courseService.updateCourse(course);
		return "redirect:/course/selectCourse/1";
	}
	
	/**
	 * 按不同条件查询课程，分页返回
	 * @param pageIndex
	 * @param course
	 * @param map
	 * @return
	 */
	@RequestMapping("queryCourse/{pageIndex}")
	public String queryCourse(@PathVariable("pageIndex")Integer pageIndex,@ModelAttribute Course course,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		HashMap<String,Object> hashMap = new HashMap<>();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(courseService.queryCourse(course).size());
		hashMap.put("course",course);
		hashMap.put("page", pageModel);
		List<Course> list = courseService.queryCourseByPage(hashMap);
		map.put("page", pageModel);
		map.put("courseList", list);
		map.put("queryCourse", course);
		return "course/showQueryCourse";
	}
	
	
}
