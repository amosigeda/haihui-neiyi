package com.light.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.shop.bean.Product;
import com.light.shop.bean.UserInfo;
import com.light.shop.dao.ProductDao;
import com.light.shop.dao.UserInfoDao;
import com.light.shop.service.ProductShowInfoService;
import com.light.shop.service.UserInfooService;

@Service("productShowInfoService")
public class ProductShowInfoServiceImpl implements ProductShowInfoService{

	 @Autowired
	private ProductDao productMapper;//注入dao

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productMapper.;
	}


}
