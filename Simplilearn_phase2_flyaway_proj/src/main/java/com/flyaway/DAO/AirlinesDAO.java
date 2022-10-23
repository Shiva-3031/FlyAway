package com.flyaway.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.flyaway.bean.AirlinesBean;
import com.flyaway.hibernate.HibernateUtil;

public class AirlinesDAO {
	
	public static boolean setNewAirlines(String airlinename) {
		System.out.println("set new airlines invoked");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
		
			AirlinesBean ab = new AirlinesBean();

			ab.setAirlineName(airlinename);

			session.save(ab);
			return true;
		}
		catch(Exception e) {
			if(session.getTransaction() != null) {
				transaction.rollback();
				return false;
			}
		}
		finally {
			session.close();
		}
		return false;
	}
	
	public static boolean checkAirline(String airlinename) {
		
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String query = "SELECT A.airlineName FROM AirlinesBean A WHERE airlineName = :airname";
		
		Query query1 =session.createQuery(query);
		
		query1.setParameter("airname", airlinename);
		
		List<AirlinesDAO> result = query1.list();
		
		System.out.println(result.toString());
		
		if(result == null || result.isEmpty()) {
			System.out.println("false ans");
			return false;
		}
		
		session.close();
		factory.close();
		System.out.println("Hello");
		return true;
		
	}
	
	public static boolean checkAndSetAirline(String airlinename) {

		if(checkAirline(airlinename)) {
			return true;
		}
		else {
			System.out.println("this one came");
			return setNewAirlines(airlinename);
		}
		
	}
	
	public static int airlineId(String airlinename) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("SELECT airlineId FROM AirlinesBean WHERE airlineName = :ar ");
		query.setParameter("ar", airlinename);
		
		List<AirlinesBean> list = query.list();
		int id = 0;
		for(AirlinesBean ab: list) {
			id = ab.getAirlineId();
			break;
		}
		session.close();
		return id;
		
	}
	
	public static List<AirlinesBean> airlinesList(){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("SELECT * FROM AirlinesBean");
		List<AirlinesBean> list = query.list();
		
		session.close();
		
		return list;
		
	}
}
