package com.wangwang.springmvcfirst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 首页的控制器
 * @author Administrator
 *
 */
public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","spring mvc start index");
		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	}

}
