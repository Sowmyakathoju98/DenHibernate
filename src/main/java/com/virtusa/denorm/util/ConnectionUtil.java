package com.virtusa.denorm.util;

import java.sql.Connection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.denorm.exception.ShoppingException;

public class ConnectionUtil {
static Connection con;
	
	public static Session getConnection() throws ShoppingException {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		return session;
	}
}
