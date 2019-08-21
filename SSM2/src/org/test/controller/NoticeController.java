package org.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.entity.Notice;
import org.test.service.impl.NoticeServiceImpl;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeServiceImpl noticeService;

	public void setNoticeService(NoticeServiceImpl noticeService) {
		this.noticeService = noticeService;
	}
	
	/**
	 * 根据id，返回某id接收到的通知
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("myReceive/{id}")
	public String myReceive(@PathVariable("id") Integer id,
			Map<String,Object> map) {
		List<Notice> notice = noticeService.queryNoticeByReceiverId(id);
		map.put("notice", notice);
		return "notice/myReceive";
	}
	
	/**
	 * 根据id，返回某人写过的通知
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("myWrite/{id}")
	public String myWrite(@PathVariable("id") Integer id,
			Map<String,Object> map) {
		List<Notice> notice = noticeService.queryNoticeBySenderId(id);
		map.put("notice", notice);
		return "notice/myWrite";
	}
	
	/**
	 * 实行提交操作，将通知存到数据库
	 * @param notice
	 * @param user_id
	 * @return
	 */
	@RequestMapping("submit")
	public String submitNotice(@ModelAttribute Notice notice,
			@RequestParam("user_id")Integer user_id) {
		notice.setSender_id(user_id);
		noticeService.addNotice(notice);
		return "redirect:/myWrite/"+user_id;
	}
	
	/**
	 * 跳转到写通知的页面
	 * @return
	 */
	@RequestMapping("writeNotice")
	public String writeNotice() {
		return "notice/writeNotice";
	}
	
	/**
	 * 尚未实装
	 * @return
	 */
	@RequestMapping("teacher")
	public String showTeacherNotice() {
		return "notice/teacherNotice";
	}
}
