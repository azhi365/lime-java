/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.superman;

/**
 * 超人工厂
 * @author YZhi
 * @since 1.0
 */
public class SuperManFactory {
	public static ISuperMan createSuperMan(String type){
		if(type.equalsIgnoreCase("adult")){
			return new AdultSuperMan();
		}else if (type.equalsIgnoreCase("child")) {
			return new ChildSuperMan();
		}else {
			return null;
		}
	}
}
