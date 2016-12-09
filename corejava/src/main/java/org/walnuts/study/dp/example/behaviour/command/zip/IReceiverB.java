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
 * 依照职责设计的接收者接口
 * @author YZhi
 * @since 1.0
 */
public interface IReceiverB {
	public boolean zipExec(String source,String to);
	public boolean gzipExec(String source,String to);
}
