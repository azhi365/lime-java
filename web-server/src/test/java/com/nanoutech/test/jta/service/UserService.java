package com.nanoutech.test.jta.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.nanoutech.test.jta.dao.IUserDao;

public class UserService implements IUserService {
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private IUserDao userDao;

	public void xa_save() {
		String userName = "user_" + Math.round(Math.random() * 10000);

		this.logger.info(userName);

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into user(username, gender) values(?,?); ");
		Object[] objs = new Object[] { userName, 1 };

		userDao.save("A", sql.toString(), objs);

		sql.delete(0, sql.length());
		sql.append(" insert into user(name, sex) values(?,?); ");
		objs = new Object[] { userName, 0 };// 值超出范围
		userDao.save("B", sql.toString(), objs);
	}

	@Override
	public void xa_save_error() {
		String userName = "user_" + Math.round(Math.random() * 10000);
		System.out.println(userName);

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into user(username, gender) values(?,?); ");
		Object[] objs = new Object[] { userName, 1 };

		userDao.save("A", sql.toString(), objs);

		sql.delete(0, sql.length());
		sql.append(" insert into user(name, sex) values(?,?); ");
		objs = new Object[] { userName, 10 };// 值超出范围
		userDao.save("B", sql.toString(), objs);
	}

	@Override
	public void addToSingle() {
		String userName = "user_" + Math.round(Math.random() * 10000);
		System.out.println(userName);

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into user(username, gender) values(?,?); ");
		Object[] objs = new Object[] { userName, 1 };
		userDao.save("", sql.toString(), objs);

		sql.delete(0, sql.length());
		sql.append(" insert into user(username, gender) values(?,?); ");
		objs = new Object[] { userName, 10 }; // 异常值超出范围
		userDao.save("", sql.toString(), objs);
	}

}