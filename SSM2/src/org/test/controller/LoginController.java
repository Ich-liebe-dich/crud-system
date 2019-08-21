package org.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.test.constant.Constant;
import org.test.entity.Admin;
import org.test.entity.Student;
import org.test.entity.Teacher;
import org.test.service.impl.AdminServiceImpl;
import org.test.service.impl.StudentServiceImpl;
import org.test.service.impl.TeacherServiceImpl;

@Controller
@SessionAttributes({Constant.USER_SESSION,Constant.USER_TYPE})
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@Autowired
	private TeacherServiceImpl teacherService;
	
	@Autowired
	private AdminServiceImpl adminService;
	
	/**
	 * 登录
	 * @param id
	 * @param password
	 * @param role
	 * @param map
	 * @return
	 */
	@RequestMapping("check")
	public String loginCheck(@RequestParam("account")Integer id,
			@RequestParam("password")String password,
			@RequestParam("role")String role,Map<String,Object> map) {
		
		if("student".equals(role)) {
			Student stu = new Student();
			stu.setId(id);
			stu.setPassword(password);
			List<Student> result = null;
			result = studentService.queryStudent(stu);
			if(result!=null && result.size()>0 ) {
				map.put(Constant.USER_SESSION, result.get(0));
				map.put(Constant.USER_TYPE,"student");
				return "main";
			}
		}else if("teacher".equals(role)) {
			Teacher teacher = new Teacher();
			teacher.setId(id);
			teacher.setPassword(password);
			List<Teacher> result = null;
			result = teacherService.queryTeacher(teacher);
			if(result!=null&& result.size()>0){
				map.put(Constant.USER_SESSION, result.get(0));
				map.put(Constant.USER_TYPE,"teacher");
				return "main";
			}
		}else if("admin".equals(role)) {
			Admin admin = new Admin();
			admin.setId(id);
			admin.setPassword(password);
			List<Admin> result = null;
			result = adminService.queryAdmin(admin);
			if(result!=null && result.size()>0) {
				map.put(Constant.USER_SESSION,result.get(0));
				map.put(Constant.USER_TYPE,"admin");
				return "main";
			}
		}
		map.put("msg","账号或密码错误！");
		return "loginForm";
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.removeAttribute(Constant.USER_SESSION);
		session.removeAttribute(Constant.USER_TYPE);
		session.invalidate();
		return "redirect:../loginForm";
	}
}
