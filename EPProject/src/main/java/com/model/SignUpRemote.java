package com.model;

import javax.ejb.Remote;

import com.entity.SignUp;

@Remote
public interface SignUpRemote 
{
	public String createAccount(SignUp sgnup) throws Exception;
}
