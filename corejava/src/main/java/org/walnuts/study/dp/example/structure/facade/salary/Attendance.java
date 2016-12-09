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
 * 考勤情况 
 * @author YZhi
 * @since 1.0
 */
public class Attendance {
	public int getWorkDays(){
		return (new Random()).nextInt(30);
	}
}
