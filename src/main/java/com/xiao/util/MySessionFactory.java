package com.xiao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

final public class MySessionFactory {

	private static SessionFactory sessionFactory = null;
	private static Configuration configuration;
	static {
		configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry registry = builder.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(registry);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
