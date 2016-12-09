/**
 * @author yzhi
 * @date 2012-1-30 上午09:23:01
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.intercepreter.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class CalculateClient {
	public static void main(String[] args) throws IOException {
		String expStr = getExpStr();
		HashMap<String, Integer> var = getValue(expStr);
		Calculator cal = new Calculator(expStr);
		System.out.println("the result is:" + expStr + cal.run(var));
	}
	
	public static String getExpStr() throws IOException{
		System.out.println("input expression:");
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}
	public static HashMap<String, Integer> getValue(String expStr) throws IOException{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (char ch : expStr.toCharArray()) {
			if(ch != '+' && ch != '-'){
				if(!map.containsKey(String.valueOf(ch))){
					String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					map.put(String.valueOf(ch), Integer.valueOf(in));
				}
			}
		}
		return map;
	}
}
