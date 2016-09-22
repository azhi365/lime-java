/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:06:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

/**
 * 撤销命令
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class CancelDeleteCommand extends Command {

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Command#execute()
	 */
	@Override
	public void execute() {
		super.pg.rollBack();
	}

}
