package com.wangwang.springmvcfirst.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.wangwang.springmvcfirst.domain.Dept;
/**
 * 部门dao.
 * @author Administrator
 *
 */
@Component
public interface IDeptDao {
	/**
	 * 获得所有的部门信息.
	 * @return 所有的部门信息.
	 */
  public List<Dept> findAll();
}
