package com.xiao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiao.entity.District;
import com.xiao.entity.House;
import com.xiao.entity.HouseCond;
import com.xiao.entity.Street;
import com.xiao.entity.Type;
import com.xiao.entity.Users;
import com.xiao.service.HouseService;
import com.xiao.util.TokenProccessor;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService houseService;

	private static final Logger log = Logger.getLogger(HouseController.class);

	@RequestMapping("/ajax_search.do")
	public void ajaxsearchHouseByCond(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String jsonStr = req.getParameter("conditions");
		System.out.println("jsonStr:" + jsonStr + "  url:" + req.getServletPath());
		JSONObject conditions = JSON.parseObject(jsonStr);
		HouseCond houseCond = new HouseCond();
		houseCond.setTitle(conditions.getString("title").trim());
		houseCond.setPrice(conditions.getString("price").trim());
		houseCond.setStreet_id(conditions.getString("street_id").trim());
		houseCond.setType_id(conditions.getString("type_id").trim());
		houseCond.setFloorage(conditions.getString("floorage").trim());
		String pageNo = req.getParameter("pageNo").trim();
		String pageSize = req.getParameter("pageSize").trim();
		System.out.println(pageNo + "     " + pageSize);
		Integer pageNoInt, pageSizeInt;
		try {
			pageNoInt = Integer.valueOf(pageNo);
			pageSizeInt = Integer.valueOf(pageSize);
		} catch (Exception e) {
			pageNoInt = 1;
			pageSizeInt = 6;
		}

		JSONObject result = houseService.findJsonHouseByCond(houseCond, pageNoInt, pageSizeInt);
		PrintWriter out = resp.getWriter();
		out.write(result.toJSONString());
		out.flush();
		out.close();
		System.out.println("controller:" + result.toJSONString());
	}

	@RequestMapping("/detail.do")
	public String searchHouseDetail(HttpServletRequest req, HttpServletResponse resp, Model model) {
		String id = req.getParameter("id");
		Integer int_id;
		House house;
		if (id == null || id.length() < 1) {
			house = new House();
		} else {
			try {
				int_id = Integer.valueOf(id);
			} catch (Exception e) {
				int_id = 0;
			}
			house = houseService.findHouseDetail(int_id);
			if (house == null)
				house = new House();
		}
		model.addAttribute("house", house);
		System.out.println(house);
		return "detail";
	}

	/**
	 * 响应表单
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/getCreateHouseForm.do")
	public String getCreateHouseForm(HttpServletRequest req, Model model) {
		String token = TokenProccessor.getInstance().makeToken();
		System.out.println("----------生成的house_token:" + token + "-----------");
		req.getSession().setAttribute("house_token", token);

		// shiro判断过user是否存在
		Users user = (Users) req.getSession().getAttribute("user");
		House house = new House();
		Type type = new Type();
		Street street = new Street();
		District district = new District();
		street.setDistrict(district);
		house.setUsers(user);
		house.setType(type);
		house.setStreet(street);
		model.addAttribute("house", house);
		return "fabu";
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * 
	 * 		考虑token
	 * @throws Exception
	 */
	@RequestMapping("/create_house.do")
	public String createHouse(@Validated @ModelAttribute House house, BindingResult bindingResult,
			HttpServletRequest req) throws Exception {
		System.out.println("----------" + house);
		// 判断是否重复提交
		if (TokenProccessor.isRepeatSubmit(req, "house_token") == true) {
			System.out.println("house_create------请不要重复提交");
			return "repate";
		}

		// 获取校验错误
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "UTF-8"));
			}
			req.setAttribute("allErrors", allErrors);
			return "create_fail";
		}

		// 验证成功 移除token
		req.getSession().removeAttribute("house_token");

		houseService.createHouse(house);
		return "create_success";
	}

}
