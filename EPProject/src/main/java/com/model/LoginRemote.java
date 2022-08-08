package com.model;

import javax.ejb.Remote;

import com.entity.Login;

@Remote
public interface LoginRemote
{
	public boolean ApplLogin(Login lgn) throws Exception;
	public String clickLogin(Login lgn) throws Exception;
}
