/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.facade.salary;

import java.util.Random;

/**
 * 绩效
 * @author YZhi
 * @since 1.0
 */
public class Performance {
	private BasicSalary salary = new BasicSalary();
	public int getPerformanceValue() {
		int perf = (new Random()).nextInt(100);
		return salary.getBasicSalary() * perf/100;
	}
}
