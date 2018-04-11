package com.light.shop.service;

import com.light.shop.bean.UserInfo;

public interface UserInfooService {

	UserInfo getUserInfo(String string);

	boolean insertUserInfo(String username, String password1, Integer sex, String weight, String height, String address,
			String head, Integer type);

}
