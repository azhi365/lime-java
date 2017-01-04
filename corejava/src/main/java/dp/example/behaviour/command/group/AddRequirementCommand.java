/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午02:58:18
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

/**
 * 添加需求命令
 * @author YZhi
 * @since 1.0
 */
public class AddRequirementCommand extends Command {

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Command#execute()
	 */
	@Override
	public void execute() {
		super.rg.find();
		super.rg.add();
		super.pg.add();
		super.cg.add();
		super.rg.plan();
	}

}
