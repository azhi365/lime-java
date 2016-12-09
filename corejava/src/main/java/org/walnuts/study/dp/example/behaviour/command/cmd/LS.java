/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.cmd;

/**
 * LS命令
 * @author YZhi
 * @since 1.0
 */
public class LS extends AbstractLS {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.CommandName#echo(dp.example.behaviour.command.cmd.CommandVO)
	 */
	@Override
	protected String echo(CommandVO vo) {
		return FileManager.ls(vo.formatData());
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.CommandName#getOperateParam()
	 */
	@Override
	protected String getOperateParam() {
		return LS.DEFAULT_PARAM;
	}
}
