package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.model.dto.User;

public interface UserService {
	User select(String id, String pass) throws SQLException;
}
