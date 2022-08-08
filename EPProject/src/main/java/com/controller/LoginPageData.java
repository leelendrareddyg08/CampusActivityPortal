package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Login;
import com.model.LoginRemote;

@ManagedBean(name = "loginbean", eager = true)
public class LoginPageData 
{
	String mail;
	String password;
	String outPage;
	String response;
	
	@EJB(lookup = "java:global/EPProject/LoginClass!com.model.LoginRemote")
	LoginRemote lgnrmt;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOutPage() {
		return outPage;
	}

	public void setOutPage(String outPage) {
		this.outPage = outPage;
	}

	public LoginRemote getLgnrmt() {
		return lgnrmt;
	}

	public void setLgnrmt(LoginRemote lgnrmt) {
		this.lgnrmt = lgnrmt;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public String validate()
	{
		try
		{
			Login lgn = new Login();
			lgn.setEmail(mail);
			lgn.setPassword(password);
			boolean bn = lgnrmt.ApplLogin(lgn);
			if(bn)
			{
				outPage =  "HomeAfLn";
			}
		}
		catch(Exception e)
		{
			outPage = "invalid";
		}
		return outPage;
	}
	
	public String CheckCredentials()
	{
		try
		{
			Login lgn = new Login();
			lgn.setEmail(mail);
			lgn.setPassword(password);
			response = lgnrmt.clickLogin(lgn);
		}
		catch(Exception e)
		{
			response = e.getMessage();
		}
		return response;
	}
}
