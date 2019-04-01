package com.qa.roomGateway.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Event {
	@Id
	private String id;
	private String title;
	private Date start;
	private Date end;

	public Event() {
	}

	public Event(String title, Date start, Date end) {
		this.title = title;
		this.start = start;
		this.end = end;
		this.id= ObjectId.get().toString();
	}

	public String get_id() {
		return id;
	}

	public void set_id(String _id) {
		this.id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return start;
	}

	public void setStartDate(Date startDate) {
		this.start = startDate;
	}

	public Date getEndDate() {
		return end;
	}

	public void setEndDate(Date endDate) {
		this.end = endDate;
	}

}
