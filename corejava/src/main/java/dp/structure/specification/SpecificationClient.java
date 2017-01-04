/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.structure.specification;

import java.util.ArrayList;

/**
 * 规格模式
 * 规格模式是组合模式和策略的综合应用
 * @author YZhi
 * @since 1.0
 */
public class SpecificationClient {
	
	public void testSpecification(){
		ArrayList<Object> list = new ArrayList<Object>();
		ISpecification specA = new BizSpecification(new Object());
		ISpecification specB = new BizSpecification(new Object());
		for (Object obj : list) {
			if(specA.and(specB).isSatisfiedBy(obj))
			System.out.println(obj);
		}
	}
}
