/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.facade.salary;

import java.util.Date;

/**
 * HR门面
 * @author YZhi
 * @since 1.0
 */
public class HRFacade {
	private SalaryProvider salaryProvider = new SalaryProvider();
	private Attendance attendance = new Attendance();
	public int querySalary(String name,Date date){
		return salaryProvider.totalSalary();
	}
	
	public int queryWorkDays(String name){
		return attendance.getWorkDays();
	}
}
