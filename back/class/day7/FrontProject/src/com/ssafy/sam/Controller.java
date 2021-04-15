package com.ssafy.sam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String requestHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
