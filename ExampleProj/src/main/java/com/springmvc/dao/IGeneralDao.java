package com.springmvc.dao;

import java.io.Serializable;
import java.util.List;

import com.springmvc.model.User;

public interface IGeneralDao {
	public int insertRow(User employee);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User employee);

	public int deleteRow(int id);

}
