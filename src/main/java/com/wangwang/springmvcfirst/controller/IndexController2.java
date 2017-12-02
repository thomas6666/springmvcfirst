package com.wangwang.springmvcfirst.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class IndexController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //request.setAttribute("name", "handler for httpRequestHandler");
       //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	  //响应自定义的内容
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write("{\"name\":\"springmvc222\",\"year\":2017}");
	
	}

}
