package com.light.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.shop.bean.ProductDetailInfo;
import com.light.shop.dao.ProductDetailInfoDao;
import com.light.shop.service.ProductDetailInfoService;

@Service("productDetailInfoService")
public class ProductDetailInfoServiceImpl implements ProductDetailInfoService{

	 @Autowired
	private ProductDetailInfoDao productDetailInfoDao;//注入dao

	@Override
	public ProductDetailInfo getProductInfoById(Integer id) {
		return productDetailInfoDao.selectByPrimaryKey(id);
	}
	 
	

}
