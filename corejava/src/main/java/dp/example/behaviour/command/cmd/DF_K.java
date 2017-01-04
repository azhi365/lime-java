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
 * df -k命令
 * @author YZhi
 * @since 1.0
 */
public class DF_K extends AbstractDF {
	protected String getOperateParam(){
		return DF_K.K_PARAM;
	}
	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.CommandName#echo(dp.example.behaviour.command.cmd.CommandVO)
	 */
	@Override
	protected String echo(CommandVO vo) {
		return DiskManager.df_k();
	}
}
