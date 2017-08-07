package com.xiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

import com.xiao.util.MySessionFactory;

public class OpenSessionInViewFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session=null;
		try {
			MySessionFactory mySessionFactory=new MySessionFactory();
			session = mySessionFactory.getSession();
			System.out.println("session  Oepen-----------------"
					+ session.hashCode());
			session.beginTransaction();
			System.out.println("------------------------------------");
			System.out.println("过滤器中session:" + session.hashCode());
			System.out.println("------------------------------------");
			chain.doFilter(request, response);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} 
		System.out.println("session closed------------------"+session.hashCode());
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
