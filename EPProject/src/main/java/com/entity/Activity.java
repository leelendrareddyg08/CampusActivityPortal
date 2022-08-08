package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	int activityid;
	@Column(name = "name")
	String activityname;
	@Column(name = "date")
	String activitydate;
	@Column(name = "type")
	String activitytype;
	@Column(name = "info")
	String activityinfo;
	public int getActivityid() {
		return activityid;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getActivitydate() {
		return activitydate;
	}
	public void setActivitydate(String activitydate) {
		this.activitydate = activitydate;
	}
	public String getActivitytype() {
		return activitytype;
	}
	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}
	public String getActivityinfo() {
		return activityinfo;
	}
	public void setActivityinfo(String activityinfo) {
		this.activityinfo = activityinfo;
	}
	
}
