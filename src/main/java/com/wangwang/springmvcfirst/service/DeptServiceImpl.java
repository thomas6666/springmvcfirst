package com.wangwang.springmvcfirst.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wangwang.springmvcfirst.dao.IDeptDao;
import com.wangwang.springmvcfirst.domain.Dept;

@Component
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao deptDao;

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

	
}
