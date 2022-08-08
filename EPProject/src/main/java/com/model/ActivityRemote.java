package com.model;

import java.util.List;

import javax.ejb.Remote;

import com.entity.Activity;

@Remote
public interface ActivityRemote 
{
	public String NewActivity(Activity act) throws Exception;
	public String EditActivity(int activityid, Activity act) throws Exception;
	public String DeleteActivity(int id) throws Exception;
	public List<Activity> DisplayActivity() throws Exception;
}
