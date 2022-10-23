package com.flyaway.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

			factory = configuration.buildSessionFactory(builder.build());

			return factory;
		}
		catch(Exception e) {
			System.out.println("Exception in the hibernate util file");
		}
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		if(factory == null)
			factory = buildSessionFactory();
		return factory;
	}

}
