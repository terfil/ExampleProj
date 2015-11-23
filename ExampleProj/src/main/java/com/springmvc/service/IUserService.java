package com.springmvc.service;



import java.util.List;

import com.springmvc.model.User;

public interface IUserService {

	public boolean register(User user);
	public List<User> list();

}