/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.zip;

import org.junit.Test;

import org.walnuts.study.dp.example.behaviour.command.zip.AbstractCmd;
import org.walnuts.study.dp.example.behaviour.command.zip.Invoker;
import org.walnuts.study.dp.example.behaviour.command.zip.ZipCompressCmd;
import org.walnuts.study.dp.example.behaviour.command.zip.ZipUncompressCmd;

/**
 * 策略模式VS命令模式
 * 策略模式让算法独立，并且可以相互替换，让行为的变化独立于拥有行为的客户，关心的是算法是否可以相互替换
 * 命令模式是对动作的解耦，把一个动作的执行分为执行对象(接收者角色)、执行行为(命令角色)，让两者相互独立
 * @author YZhi
 * @since 1.0
 */
public class ZipClient {
	/**
	 *策略模式
	 */
	@Test
	public void testZipStrategy(){
		Context context = new Context(new Zip());
		context.compress("c:\\", "d:\\a.zip");
		context = new Context(new Gzip());
		context.uncompress("d:\\a.zip", "c:\\");;
	}
	
	/**
	 *命令模式
	 */
	@Test
	public void testZipCommand(){
		AbstractCmd abstractCmd = new ZipCompressCmd();
		
		abstractCmd = new ZipUncompressCmd();
		Invoker invoker = new Invoker(abstractCmd);
		invoker.execute("c:\\", "d:\\a.zip");
	}

}
