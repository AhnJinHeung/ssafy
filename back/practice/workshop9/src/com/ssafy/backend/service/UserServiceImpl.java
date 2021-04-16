package com.ssafy.backend.service;

import java.sql.SQLException;

import com.ssafy.backend.dao.UserDaoImpl;
import com.ssafy.backend.dto.User;

public class UserServiceImpl implements UserService {
	private static UserService userService;
	
	private UserServiceImpl() {}
	
	public static UserService getUserService() {
		if (userService == null)
			userService = new UserServiceImpl();
		return userService;
	}
	
	@Override
	public User doLogin(String id, String pwd) throws SQLException {
		return UserDaoImpl.getUserService().doLogin(id, pwd);
	}
}
