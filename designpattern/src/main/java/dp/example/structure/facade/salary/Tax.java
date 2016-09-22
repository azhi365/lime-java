/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.facade.salary;

import java.util.Random;

/**
 * 税收
 * @author YZhi
 * @since 1.0
 */
public class Tax {
	public int getTax(){
		return (new Random()).nextInt(300);
	}
}
