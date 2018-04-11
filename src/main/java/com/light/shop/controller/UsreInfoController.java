package com.light.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.light.shop.bean.UserInfo;
import com.light.shop.service.UserInfooService;

@Controller
public class UsreInfoController {

	@Autowired
	private UserInfooService userInfoService;

	@RequestMapping("/hello")
	public void hello() {

	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/products")
	public String product() {
		return "products";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String index(String name, Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", name);
		return "/user";
	}

	// 登录
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		UserInfo userinfo = userInfoService.getUserInfo(username);
		if (userinfo != null) {
			if (password.equals(userinfo.getPassword())) {
				return "/loginSuccess";
			} else {
				return "/passwordError";
			}
		} else {
			return "/loginFail";
		}
	}

	// 注册
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String username, 
			@RequestParam String password1,
			@RequestParam String password2, 
			@RequestParam Integer sex,
			@RequestParam(value = "weight", required = false) String weight,
			@RequestParam(value = "height", required = false) String height,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "head", required = false) String head,
			@RequestParam Integer type
			) {
		if (StringUtils.isEmpty(type)) {
			type = 1;
		}
		UserInfo userinfo = userInfoService.getUserInfo(username);
		if(userinfo !=null ){
			 return "/userExist";
		}else{

			if(!password1.equals(password2)){
				 return "/passwordError";
			}else{
				userInfoService.insertUserInfo(username,password1,sex,weight,height,address,head,type);
				return "/registerSuccess";
				
			}
		}
		

	}

}
