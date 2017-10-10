package com.innstack.lime.test.jta.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao implements IUserDao {

	@Resource
	private JdbcTemplate jdbcTemplateA;
	@Resource
	private JdbcTemplate jdbcTemplateB;
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplateA(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateA = jdbcTemplate;
	}

	public void setJdbcTemplateB(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateB = jdbcTemplate;
	}

	public int save(String ds, String sql, Object[] obj) {
		if (ds.equals("A")) {
			return this.jdbcTemplateA.update(sql, obj);
		} else if(ds.equals("B")) {
			return this.jdbcTemplateB.update(sql, obj);
		}else{
			return this.jdbcTemplate.update(sql, obj);
		}
	}
}