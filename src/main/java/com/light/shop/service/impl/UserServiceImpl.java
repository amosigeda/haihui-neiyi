package com.light.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.light.shop.bean.UserInfo;
import com.light.shop.dao.UserInfoDao;
import com.light.shop.service.UserInfooService;

@Service("userService")
public class UserServiceImpl implements UserInfooService{

	 @Autowired
	private UserInfoDao userMapper;//注入dao
	 
	@Override
	public UserInfo getUserInfo(String string) {
		
		return userMapper.selectByUserName(string);
	}

	@Override
	public boolean insertUserInfo(String username, String password1, Integer sex, String weight, String height,
			String address, String head, Integer type) {
		
		return userMapper.insertUserInfo(username,password1,sex,weight,height,address,head,type);
	}

}
