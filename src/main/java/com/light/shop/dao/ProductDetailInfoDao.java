package com.light.shop.dao;

import java.util.List;

import com.light.shop.bean.ProductDetailInfo;



public interface ProductDetailInfoDao{

	public List<ProductDetailInfo> queryAll();

	public ProductDetailInfo selectByPrimaryKey(Integer id);
}
