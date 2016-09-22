package com.nanoutech.test.jta.service;

public interface IUserService {

	/**
	 * 正常插入
	 * @throws Exception
	 */
	public void xa_save();

	/**
	 * 异常插入
	 */
	public void xa_save_error();

	/**
	 * 
	 */
	public void addToSingle();

}