/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 命令模式+责任链模式
 * @author YZhi
 * @since 1.0
 */
public class CmdClient {
	
	@Test
	public void testCmd() throws IOException{
		Invoker invoker = new Invoker();
		System.out.println("#");
		String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		if(input.equals("quit") || input.equals("exit")){
			return;
		}
		System.out.println(invoker.exec(input));
	}
}
