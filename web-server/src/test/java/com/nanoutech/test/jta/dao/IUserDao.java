package com.nanoutech.test.jta.dao;

public interface IUserDao {
	int save(String ds, String sql, Object[] obj);
}