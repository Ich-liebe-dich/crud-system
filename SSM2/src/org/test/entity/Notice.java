package org.test.entity;

import java.util.Date;

public class Notice {
	
	private Integer id;    //ͨid
	private Integer sender_id;  //发通知的人的id
	private Integer receiver_id;   //接受者的id
	private String title;  //标题
	private String content; //内容  
	private Date date;  //发送时间
	
	public Notice() {
		
	}
	
	public Notice(Integer sender_id, Integer receiver_id, String title, String content, Date date) {
		super();
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public Integer getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(Integer receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
