package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.springmvc.dao.IGeneralDao;
import com.springmvc.model.User;

@Service
@Qualifier("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IGeneralDao generalDao;
	
	@Transactional(readOnly=false)
	public boolean register(User user) {
		generalDao.insertRow(user);
		return false;
	}

	@Override
	public List<User> list() {
		List<User> l = generalDao.getList();
		return l;
	}
}