package org.test.service;

import java.util.List;

import org.test.entity.Notice;

public interface NoticeService {
	
	int addNotice(Notice notice);
	
	List<Notice> queryNoticeByReceiverId(Integer id);
	
	List<Notice> queryNoticeBySenderId(Integer id);
}
