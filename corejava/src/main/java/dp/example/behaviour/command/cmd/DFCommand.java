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
 * 可执行的df命令
 * @author YZhi
 * @since 1.0
 */
public class DFCommand extends Command {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.cmd.Command#execute(dp.example.behaviour.command.cmd.CommandVO)
	 */
	@Override
	public String execute(CommandVO vo) {
		return super.bulidChain(AbstractDF.class).get(0).handlerMessage(vo);
	}

}
