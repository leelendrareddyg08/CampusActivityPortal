package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import com.entity.Login;

@Stateless
public class LoginClass implements LoginRemote
{
	public boolean ApplLogin(Login lgn) throws Exception
	{
		boolean rtnvalue = false;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eps9","root","admin");
		PreparedStatement pstmnt = conn.prepareStatement("select * from signup where mail = ? and password = ?");
		pstmnt.setString(1, lgn.getEmail());
		pstmnt.setString(2, lgn.getPassword());
		ResultSet rs = pstmnt.executeQuery();
		if(rs.next())
		{
			rtnvalue = true;
		}
		conn.close();
		return rtnvalue;
	}

	@Override
	public String clickLogin(Login lgn) throws Exception 
	{
		String response = "fail";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eps9","root","admin");
		PreparedStatement pstmnt = conn.prepareStatement("select * from signup where mail = ? and password = ?");
		pstmnt.setString(1, lgn.getEmail());
		pstmnt.setString(2, lgn.getPassword());
		ResultSet rs = pstmnt.executeQuery();
		if(rs.next())
		{
			response = "success";
		}
		conn.close();
		return response;
	}
}
