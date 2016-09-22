/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.facade.salary;


/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class SalaryProvider {
	private BasicSalary basicSalary = new BasicSalary();
	private Bonus bonus = new Bonus();
	private Performance perf = new Performance();
	private Tax tax = new Tax();
	public int totalSalary(){
		return basicSalary.getBasicSalary() + bonus.getBonus() +
		perf.getPerformanceValue() - tax.getTax();
	}
}
