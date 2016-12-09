/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:35:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.calculator;

/**
 * 策略枚举
 * @author YZhi
 * @since 1.0
 */
public enum Calculator {
	ADD("+"){
		public int exec(int a,int b){
			return a + b;
		}
	},
	SUB("-"){
		public int exec(int a,int b){
			return a-b;
		}
	};
	String value = "";
	
	private Calculator(String value){
		this.value = value;
	}
	
	public abstract int exec(int a,int b);
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}	
}
