/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午04:33:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.visitor.employee;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class EmployeeClient {
	@Test
	public void testEmployeeVisitor(){
		List<Employee> empList = new ArrayList<Employee>();
		IVisitor visitor = new Visitor();
		CommonEmployee zhangsan = new CommonEmployee();
		zhangsan.setJob("java developer");
		zhangsan.setName("zhangsan");
		zhangsan.setSalary("1000");
		zhangsan.setSex(Employee.MALE);
		empList.add(zhangsan);
		CommonEmployee lisi = new CommonEmployee();
		lisi.setJob("UI develpoer");
		lisi.setName("lisi");
		lisi.setSalary("900");
		lisi.setSex(Employee.FEMALE);
		empList.add(lisi);
		Manager wangwu = new Manager();
		wangwu.setName("wangwu");
		wangwu.setPerformance("good");
		wangwu.setSalary("10000");
		wangwu.setSex(Employee.MALE);
		empList.add(wangwu);
		for (Employee employee : empList) {
			employee.accept(visitor);
		}
		System.out.println(visitor.getTotalSalary());
	}
}
