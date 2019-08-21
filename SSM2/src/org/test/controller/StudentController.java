package org.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.constant.Constant;
import org.test.entity.PageModel;
import org.test.entity.Student;
import org.test.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("student")
public class StudentController {
    
	@Autowired    
	@Qualifier("studentService")
	StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	/**
	 * 分页获取学生列表信息
	 * @param pageIndex
	 * @param map
	 * @return
	 */
	@RequestMapping("selectStudent/{pageIndex}")
	public String stuInfoPage(@PathVariable("pageIndex")Integer pageIndex,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(studentService.count(new Student()));
		List<Student> list = studentService.queryStudentListByPage(pageModel);
		map.put("stuList", list);
		map.put("page", pageModel);
		return "stu/showSelectStu";
	}	
	
	/**
	 * 增加学生
	 * @param flag
	 * @param stu
	 * @param map
	 * @return
	 */
	@RequestMapping("addStudent")
	public String stuInfo(String flag,
			 @ModelAttribute Student stu, Map<String,Object> map) {
		if("1".equals(flag)) {
			return "stu/showAddStu";
		}else {
			studentService.addStudent(stu);
			return "redirect:/student/selectStudent/1";
		}
	}
	
	/**
	 * 批量删除学生
	 * @param ids
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteStudent")
	public String deleteCourse(String ids,
			Map<String,Object> map) {
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除学生
			studentService.deleteStuById(Integer.parseInt(id));
		}
		return "redirect:/student/selectStudent/1";
	}
	
	/**
	 * 跳转到更新学生的页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("updateStudent")
	public String showUpdateStu(@RequestParam("id")Integer id,
			Map<String,Object> map) {
		Student stu = studentService.queryStudentById(id);
		map.put("stu", stu);
		return "stu/showUpdateStu";
	}
	
	/**
	 * 更新学生
	 * @param stu
	 * @param map
	 * @return
	 */
	@RequestMapping("updateStudent/update")
	public String updateStu(@ModelAttribute Student stu,
			Map<String,Object> map) {
		studentService.updateStudent(stu);
		return "redirect:/student/selectStudent/1";
	}
	
	/**
	 * 按照不同条件查询学生，并分页返回
	 * @param pageIndex
	 * @param stu
	 * @param map
	 * @return
	 */
	@RequestMapping("queryStudent/{pageIndex}")
	public String queryStudent(@PathVariable("pageIndex")Integer pageIndex,@ModelAttribute Student stu,Map<String,Object> map) {
		PageModel pageModel = new PageModel();
		HashMap<String,Object> hashMap = new HashMap<>();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		pageModel.setRecordCount(studentService.queryStudent(stu).size());
		hashMap.put("stu",stu);
		hashMap.put("page", pageModel);
		List<Student> list = studentService.queryStudentByPage(hashMap);
		map.put("stuList", list);
		map.put("page", pageModel);
		map.put("queryStu",stu);
		return "stu/showQueryStu";
	}
	
	/**
	 * 根据 id 获取学生个人信息
	 * @param id
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("info/{id}")
	public String queryPrivateInfo(@PathVariable("id")Integer id,
			Map<String,Object> map,HttpSession session) {
		//检查session中的id与请求的id是否匹配
		Student session_stu = (Student)session.getAttribute(Constant.USER_SESSION);
		if(session_stu.getId().equals(id)) {
			Student stu = studentService.queryStudentById(id);
			map.put("stu", stu);
			return "stu/showStuPrivateInfo";
		}
		return "redirect:/404.html";
	}
	
	/**
	 * 根据 id 获取学生课程信息
	 * @param id
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("myCourse/{id}")
	public String queryPrivateCourse(@PathVariable("id")Integer id,
			Map<String,Object> map,HttpSession session) {
		//检查session中的id与请求的id是否匹配
		Student session_stu = (Student)session.getAttribute(Constant.USER_SESSION);
		if(session_stu.getId().equals(id)) {
			Student stu = studentService.queryStudentById(id);
			map.put("stu", stu);
			return "stu/showMyCourse";
		}
		return "redirect:/404.html";
	}
	
}
