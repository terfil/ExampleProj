package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.IGeneralDao;
import com.springmvc.model.User;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IGeneralDao generalDao;
	
	/* 
	 * 这里要有事务注解，默认readOnly=true,不设置的话会报错。
	 * insert和update操作都要。
	 */
	@Transactional(readOnly=false)
	public boolean register(User user) {
		generalDao.save(user);
		return false;
	}
}