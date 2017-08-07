package com.xiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.util.TokenProccessor;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String token = TokenProccessor.getInstance().makeToken();
		System.out.println("过滤器生成的token:" + token);
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		httpReq.getSession().setAttribute("login_token", token);
		chain.doFilter(httpReq, httpResp);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
