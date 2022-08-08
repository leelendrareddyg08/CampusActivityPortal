package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.validation.constraints.Size;

import com.entity.SignUp;
import com.model.SignUpRemote;

@ManagedBean(name = "signupbean", eager = true)
public class SignUpPageData 
{
//	@Size(min = 4, max = 11)
	long ID;
//	@Size(min = 4)
	String name;
	String gender;
//	@Size(min =8)
	String password;
//	@Size(min =6)
	String email;
//	@Size(min =10 , max =10)
	long mobileNumber;
	String response;
	
	@EJB(lookup = "java:global/EPProject/SignUpClass!com.model.SignUpRemote")
	SignUpRemote sgnrmt;
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public SignUpRemote getSgnrmt() {
		return sgnrmt;
	}

	public void setSgnrmt(SignUpRemote sgnrmt) {
		this.sgnrmt = sgnrmt;
	}
	
	public void getSignUpData()
	{
		try
		{
			SignUp sgnup = new SignUp();
			sgnup.setID(ID);
			sgnup.setName(name);
			sgnup.setEmail(email);
			sgnup.setGender(gender);
			sgnup.setPassword(password);
			sgnup.setMobileNumber(mobileNumber);
			response = sgnrmt.createAccount(sgnup);
		}
		catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	
}
