package org.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.Notice;
import org.test.mapper.NoticeMapper;
import org.test.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public int addNotice(Notice notice) {
		return noticeMapper.addNotice(notice);
	}

	@Override
	public List<Notice> queryNoticeByReceiverId(Integer id) {
		return noticeMapper.queryNoticeByReceiverId(id);
	}

	@Override
	public List<Notice> queryNoticeBySenderId(Integer id) {
		return noticeMapper.queryNoticeBySenderId(id);
	}

	public void setNoticeMapper(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

}
