/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午02:56:51
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

/**
 * 抽象命令
 * @author YZhi
 * @since 1.0
 */
public abstract class Command {
	protected RequirementGroup rg = new RequirementGroup();
	protected PageGroup pg = new PageGroup();
	protected CodeGroup cg = new CodeGroup();
	public abstract void execute();
}
