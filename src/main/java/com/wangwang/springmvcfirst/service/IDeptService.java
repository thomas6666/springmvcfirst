package com.wangwang.springmvcfirst.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wangwang.springmvcfirst.domain.Dept;

@Component
public interface IDeptService {
	/**
	 * 获得所有的部门信息.
	 * @return 部门信息.
	 */
   public List<Dept> findAll();
}
