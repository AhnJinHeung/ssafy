package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.model.dao.UserDaoImpl;
import com.ssafy.test.model.dto.User;

public class UserServiceImpl implements UserService {
	private static UserService userService;
	
	private UserServiceImpl() {}
	
	public static UserService getUserService() {
		if (userService ==  null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
	@Override
	public User select(String id, String pass) throws SQLException {
		return UserDaoImpl.getUserDao().select(id, pass);
	}
}
