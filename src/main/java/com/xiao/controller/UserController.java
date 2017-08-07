package com.xiao.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiao.entity.Users;
import com.xiao.service.UserService;
import com.xiao.util.TokenProccessor;
import com.xiao.util.ValidateCode;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(UserController.class);

	/**
	 * 登录
	 * 
	 * @param user
	 * @param req
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("/login.do")
	public String login(@ModelAttribute Users user, HttpServletRequest req) throws InterruptedException {

		if (TokenProccessor.isRepeatSubmit(req, "user_token") == true) {
			log.warn("login------重复提交");
			req.setAttribute("error", "请不要重复登录!");
			return "repate";
		}

		// 验证成功 移除token
		req.getSession().removeAttribute("user_token");

		log.info("------------------------user:" + user);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			subject.login(token);
			req.getSession().setAttribute("user", userService.login(user));
			return "list";
		} catch (Exception e) {
			// e.printStackTrace();
			return "forward:/user/getLoginForm.do";
		}
	}

	/**
	 * 注销
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		req.getSession().invalidate();
		log.info("--------------用户注销------------");
		return "forward:/user/getLoginForm.do";
	}

	/**
	 * 获取登录表单
	 * 
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/getLoginForm.do")
	public String getLoginForm(Model model, HttpServletRequest req) {
		String token = TokenProccessor.getInstance().makeToken();
		log.info("----------生成的user_token:" + token + "-----------");
		req.getSession().setAttribute("user_token", token);
		model.addAttribute("user", new Users());
		return "login";
	}

	/**
	 * 获取验证码
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value = "/getAuthImg.do", method = RequestMethod.GET)
	@ResponseBody
	public void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setHeader("Cache-Control", "no-cache");
		String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_ALL_MIXED, 4, null);
		req.getSession().setAttribute("validateCode", verifyCode);
		resp.setContentType("image/jpeg");
		BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
		ImageIO.write(bim, "JPEG", resp.getOutputStream());
	}

	/**
	 * 注册
	 * 
	 * @param req
	 * @param user
	 * @param bindingResult
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(HttpServletRequest req, @Validated @ModelAttribute Users user, BindingResult bindingResult)
			throws UnsupportedEncodingException {
		// 判断是否重复提交
		if (TokenProccessor.isRepeatSubmit(req, "user_token") == true) {
			log.warn("register------重复提交");
			req.setAttribute("error", "重复提交注册表单!");
			return "repate";
		}

		// 验证码
		String code = req.getParameter("authCode");
		String servlet_code = (String) req.getSession().getAttribute("validateCode");

		if (!code.equals(servlet_code)) {
			log.info("rigister-----------验证失败!");
			// System.out.println("验证失败");
			req.setAttribute("error_code", "true");
			req.setAttribute("user", user);
			return "login";
		}

		// 获取校验错误
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				log.warn(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "UTF-8"));
				// System.out.println(new
				// String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),
				// "UTF-8"));
			}
			req.setAttribute("allErrors", allErrors);
			return "create_fail";
		}

		// 验证成功 移除token
		req.getSession().removeAttribute("user_token");
		userService.register(user);

		return "forward:/pages/register_success.jsp";
	}
}
