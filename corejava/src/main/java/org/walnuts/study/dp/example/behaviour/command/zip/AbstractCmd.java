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
 * 抽象压缩命令
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractCmd {
	protected IReceiver zip = new ZipReceiver();
	protected IReceiver gzip = new GzipReceiver();
	public abstract boolean execute(String source,String to);
}
