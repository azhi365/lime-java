/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午02:59:25
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

/**
 * 删除页面命令
 * @author YZhi
 * @since 1.0
 */
public class DeletePageCommand extends Command {

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Command#execute()
	 */
	@Override
	public void execute() {
		super.pg.find();
		super.pg.delete();
		super.pg.plan();
	}

}
