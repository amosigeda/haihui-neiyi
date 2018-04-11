package com.light.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.light.shop.bean.Page;
import com.light.shop.bean.Product;
import com.light.shop.bean.ProductDetailInfo;
import com.light.shop.bean.UserInfo;
import com.light.shop.controller.base.BaseController;
import com.light.shop.service.ProductDetailInfoService;
import com.light.shop.service.ProductShowInfoService;
import com.light.shop.service.UserInfooService;
import com.light.shop.util.PageData;

@Controller
public class ProductShowInfoController extends BaseController{

	@Autowired
	private ProductShowInfoService productShowInfoService;

	// 查询所有商品
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String login(Page page, Model model) {
		
		List<Product> productlist = productShowInfoService.getProductList();
	
		return "biz/fence/list";
	}

}
