package com.light.shop.controller.base;

import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.light.shop.bean.Page;
import com.light.shop.util.Const;
import com.light.shop.util.PageData;
import com.light.shop.util.UuidUtil;



public class BaseController {

	protected Logger logger = Logger.getLogger("log");

	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	public User getCurrUser() {
		return (User) getRequest().getSession().getAttribute(Const.CURR_USER);
	}

	@SuppressWarnings("unchecked")
	public Role getCurrRole() {
		List<Role> roles = (List<Role>) getRequest().getSession().getAttribute(Const.CURR_ROLES);
		if (roles != null && roles.size() > 0) {
			return roles.get(0);
		}
		return null;
	}

	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID() {
		return UuidUtil.get32UUID();
	}

	/**
	 * 得到分页列表的信息 
	 */
	public Page getPage() {
		return new Page();
	}

	public static void logBefore(Logger logger, String interfaceName) {
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}

	public static void logAfter(Logger logger) {
		logger.info("end");
		logger.info("");
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader(" x-forwarded-for ");
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" WL-Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
