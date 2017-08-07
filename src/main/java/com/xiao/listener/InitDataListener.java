package com.xiao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;
import com.xiao.entity.HouseCond;
import com.xiao.service.HouseService;

public class InitDataListener implements ServletContextListener {

	private HouseService houseService = null;

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());

		houseService = (HouseService) context.getBean(HouseService.class);
		JSONObject page = houseService.findJsonHouseByCond(new HouseCond(), 1,
				6);
		context.getServletContext().setAttribute("page", page.toJSONString());
	}

}
