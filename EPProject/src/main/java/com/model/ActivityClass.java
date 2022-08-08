package com.model;

import java.util.List;

//import javax.persistence.*;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Activity;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class ActivityClass implements ActivityRemote
{

	@Override
	public String NewActivity(Activity act) throws Exception
	{
		String response = "Activity Uploaded Successfully";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EPProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(act);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		return response;
	}

	@Override
	public String EditActivity(int activityid, Activity act) throws Exception
	{
		String response = "Activity Modified Successfully";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EPProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Activity newAct = entityManager.find(Activity.class, activityid);
		newAct.setActivitydate(act.getActivitydate());
		newAct.setActivityinfo(act.getActivityinfo());
		newAct.setActivityname(act.getActivityname());
		newAct.setActivitytype(act.getActivitytype());
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		return response;
	}

	@Override
	public String DeleteActivity(int activityid) throws Exception
	{
		String response = "Activity Deleted Successfully";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EPProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Activity act = entityManager.find(Activity.class, activityid);
		entityManager.remove(act);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		return response;
	}

//	@Override
	public List<Activity> DisplayActivity() throws Exception
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EPProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query qry = entityManager.createQuery("select n from Activity n");
		@SuppressWarnings("unchecked")
		List<Activity> lst = qry.getResultList();
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		return lst;
	}
	
}
