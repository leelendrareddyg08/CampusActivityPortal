package com.model;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.SignUp;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class SignUpClass implements SignUpRemote
{

	@Override
	public String createAccount(SignUp sgnup) throws Exception 
	{
		String response = "SignUp Successfull ! Login to Access the Portal :-]";
		EntityManagerFactory enmf = Persistence.createEntityManagerFactory("EPProject");
		EntityManager emg = enmf.createEntityManager();
		emg.getTransaction().begin();
		emg.persist(sgnup);
		emg.getTransaction().commit();
		enmf.close();
//		return "Data Insertion Successfull";
		return response;
	}
}
