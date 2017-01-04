/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.cmd;

/**
 * ls -a 命令
 * @author YZhi
 * @since 1.0
 */
public class LS_A extends AbstractLS {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.CommandName#echo(dp.example.behaviour.command.cmd.CommandVO)
	 */
	@Override
	protected String echo(CommandVO vo) {
		return FileManager.ls_a(vo.formatData());
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.CommandName#getOperateParam()
	 */
	@Override
	protected String getOperateParam() {
		return LS_A.A_PARAM;
	}

}
