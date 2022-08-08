package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Activity;
import com.model.ActivityRemote;

@ManagedBean(name = "activitybean", eager = true)
public class ActivityData 
{
	int activityid;
	String activityname;
	String activitydate;
	String activitytype;
	String activityinfo;
	String response;
	List<Activity> lst;
	
	@EJB(lookup = "java:global/EPProject/ActivityClass!com.model.ActivityRemote")
	ActivityRemote activityRemote;

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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<Activity> getLst() {
		return lst;
	}

	public void setLst(List<Activity> lst) {
		this.lst = lst;
	}

	public ActivityRemote getActivityRemote() {
		return activityRemote;
	}

	public void setActivityRemote(ActivityRemote activityRemote) {
		this.activityRemote = activityRemote;
	}
	
	public void AddNewEvent()
	{
		try
		{
			Activity act = new Activity();
			act.setActivitydate(activitydate);
			act.setActivityid(activityid);
			act.setActivityinfo(activityinfo);
			act.setActivityname(activityname);
			act.setActivitytype(activitytype);
			response = activityRemote.NewActivity(act);
		}
		catch(Exception e)
		{
			response  = e.getMessage();
		}
	}
	
	public void ModifyExistingEvent()
	{
		try
		{
			Activity act = new Activity();
			act.setActivitydate(activitydate);
			act.setActivityid(activityid);
			act.setActivityinfo(activityinfo);
			act.setActivityname(activityname);
			act.setActivitytype(activitytype);
			response = activityRemote.EditActivity(activityid, act);
		}
		catch(Exception e)
		{
			response  = e.getMessage();
		}
	}
	
	public void DeleteExistingEvent()
	{
		try
		{
			response = activityRemote.DeleteActivity(activityid);
		}
		catch(Exception e)
		{
			response  = e.getMessage();
		}
	}
	
	public void GetAllExistingEvents()
	{
		try
		{
			lst = activityRemote.DisplayActivity();
		}
		catch(Exception e)
		{
			response = e.getMessage();
		}
	}
}
