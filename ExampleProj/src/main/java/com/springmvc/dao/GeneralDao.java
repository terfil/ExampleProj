package com.springmvc.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springmvc.model.User;

@Repository
public class GeneralDao implements IGeneralDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insertRow(User employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<User> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> employeeList = session.createQuery("from User").list();
		session.close();
		return employeeList;
	}

	@Override
	public User getRowById(int id) {
		Session session = sessionFactory.openSession();
		User employee = (User) session.load(User.class, id);
		return employee;
	}

	@Override
	public int updateRow(User employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User employee = (User) session.load(User.class, id);
		session.delete(employee);
		tx.commit();
		Serializable ids = session.getIdentifier(employee);
		session.close();
		return (Integer) ids;
	}

}