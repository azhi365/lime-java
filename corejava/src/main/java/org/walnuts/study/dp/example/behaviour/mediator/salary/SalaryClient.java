/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.salary;

import java.util.Date;

import org.junit.Test;

import org.walnuts.study.dp.example.structure.facade.salary.HRFacade;

/**
 * 中介者模式VS门面模式
 * 中介者类封闭了各个同事类之间的逻辑关系，方便系统的扩展和维护
 * 门面模式只增加了一个门面，对子系统没有增加任何功能，中介者模式增加了业务功能
 * 门面模式中子系统不知道有门面的存在，而中介者中每个同事类都知道中介者存在
 * 门面模式是一种简单封装，所有的请求处理者委托给子系统完成，而中介者模式中心本身也完成部分业务n
 * @author YZhi
 * @since 1.0
 */
public class SalaryClient {
	/**
	 *中介者模式
	 */
	@Test
	public void testSalaryMediator(){
		Mediator mediator = new Mediator();
		IPosition position = new Position(mediator);
		ISalary salary = new Salary(mediator);
		ITax tax = new Tax(mediator);
		position.promote();
		System.out.println("-----------------------");
		salary.increaseSalary();
		System.out.println("-----------------------");
		tax.drop();
		System.out.println("-----------------------");
		
	}
	
	/**
	 * 门面模式
	 */
	@Test
	public void testSalaryFacade(){
		HRFacade facade = new HRFacade();
		System.out.println(facade.querySalary("张三", new Date()));
		System.out.println(facade.queryWorkDays("张三"));
	}
}
