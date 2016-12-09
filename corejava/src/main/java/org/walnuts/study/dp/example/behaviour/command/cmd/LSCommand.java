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
 * 具体的LS命令
 * @author YZhi
 * @since 1.0
 */
public class LSCommand extends Command {
	public String execute(CommandVO vo){
		CommandName firstNode = super.bulidChain(AbstractLS.class).get(0);
		return firstNode.handlerMessage(vo);
	}
}
