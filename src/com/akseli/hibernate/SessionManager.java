package com.akseli.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionManager {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory getSessionFactory() throws Exception {
		// A SessionFactory is set up once for an application
        if( null == sessionFactory ){
        	Configuration configuration = new Configuration();
            configuration.configure("/resources/hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder()
            					.applySettings(configuration.getProperties())
            					.buildServiceRegistry();        
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        return sessionFactory;
	}

	public static void close() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
}
