/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.cmd;

/**
 * df命令
 * @author YZhi
 * @since 1.0
 */
public class DF extends AbstractDF {
	protected String getOperateParam(){
		return DF.DEFAULT_PARAM;
	}
	protected String echo(CommandVO vo){
		return DiskManager.df();
	}
}
