/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.superman;

/**
 * 导演类
 * @author YZhi
 * @since 1.0
 */
public class Director {
	private static Builder adultBuilder = new AdultSuperManBulider();
	private static Builder childBuilder = new ChildSuperManBulider();
	public static SuperMan getAdultSuperMan(){
		return adultBuilder.getSuperMan();
	}
	public static SuperMan getChildSuperMan(){
		return childBuilder.getSuperMan();
	}
}
