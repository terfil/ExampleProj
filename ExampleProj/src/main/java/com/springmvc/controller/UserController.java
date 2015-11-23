package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.User;
import com.springmvc.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		User user = new User(0, "add", "999");
		userService.register(user);
		return "index";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<User> list(){
		List<User> l = new ArrayList<User>();
		l = userService.list();
		return l;
	}
}