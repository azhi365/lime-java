/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.mvc;

/**
 * 抽象Action
 * @author YZhi
 * @since 1.0
 */
public abstract class ActionSupport {
	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	public String execute(){
		return SUCCESS;
	}
}
