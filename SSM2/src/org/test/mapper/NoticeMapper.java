package org.test.mapper;

import java.util.List;

import org.test.entity.Notice;

public interface NoticeMapper {
	
	int addNotice(Notice notice);
	
	List<Notice> queryNoticeByReceiverId(Integer id);
	
	List<Notice> queryNoticeBySenderId(Integer id);
	
}
