package com.xiao.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;
	private HashMap<String, String> params = new HashMap<String, String>();

	public void destroy() {
		params = null;
		encoding = null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		for (Enumeration<?> e = config.getInitParameterNames(); e
				.hasMoreElements();) {
			String name = (String) e.nextElement();
			String value = config.getInitParameter(name);
			params.put(name, value);
		}
	}
}
