package com.wangwang.springmvcfirst.annotation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.wangwang.springmvcfirst.domain.Dept;
import com.wangwang.springmvcfirst.service.IDeptService;

@Controller
public class DeptController {
    
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("/findAll.action")
	public ModelAndView findAll(){
		ModelAndView mv=new ModelAndView();
		List<Dept> depts=deptService.findAll();
		mv.addObject("depts",depts);
		mv.setViewName("dept");
		return mv;
	}
}
