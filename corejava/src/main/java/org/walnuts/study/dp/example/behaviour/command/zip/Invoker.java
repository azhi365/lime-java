/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.zip;

/**
 * 调用者
 * @author YZhi
 * @since 1.0
 */
public class Invoker {
	private AbstractCmd abstractCmd;

	/**
	 * 
	 * 
	 * 
	 * @param abstractCmd
	 */
	public Invoker(AbstractCmd abstractCmd) {
		this.abstractCmd = abstractCmd;
	}
	
	/**
	 * 执行命令
	 *
	 * @param source
	 * @param to
	 * @return
	 */
	public boolean execute(String source,String to){
		return this.abstractCmd.execute(source, to);
	}
}
