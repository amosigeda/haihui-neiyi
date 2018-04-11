package com.light.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.light.shop.bean.ProductDetailInfo;
import com.light.shop.bean.UserInfo;
import com.light.shop.service.ProductDetailInfoService;
import com.light.shop.service.ProductShowInfoService;
import com.light.shop.service.UserInfooService;

@Controller
public class ProductDetailInfoController {

	@Autowired
	private ProductDetailInfoService productDetailInfoService;

	// 查询单个商品的详细信息
	@ResponseBody
	@RequestMapping(value = "/selectById", method = RequestMethod.POST)
	public String login(@RequestParam Integer id, Model model) {

		ProductDetailInfo product = productDetailInfoService.getProductInfoById(id);
		if (product != null) {

			return "successJsp";
		} else {
			return "failJsp";
		}

	}

}
