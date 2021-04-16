package com.ssafy.backend.service;

import java.sql.SQLException;

import com.ssafy.backend.dto.User;

public interface UserService {
	public User doLogin(String id, String pwd) throws SQLException;
}
