/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.facade.salary;

/**
 * 奖金计算
 * @author YZhi
 * @since 1.0
 */
public class Bonus {
	private Attendance atte = new Attendance();
	public int getBonus(){
		int workDays = atte.getWorkDays();
		int bonus = workDays * 1000/30;
		return bonus;
	}
}
