package com.light.shop.dao;

import org.springframework.stereotype.Repository;

import com.light.shop.bean.UserInfo;

@Repository
public interface UserInfoDao{
	UserInfo selectByUserName(String string);

	boolean insertUserInfo(String username, String password1, Integer sex, String weight, String height, String address,
			String head, Integer type);
}
