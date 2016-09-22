/**
 * 

 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象命令
 * @author YZhi
 * @since 1.0
 */
public abstract class Command {
	public abstract String execute(CommandVO vo);
	
	protected final List<? extends CommandName> bulidChain(Class<? extends CommandName> abstractClass){
		List<Class<?>> classes = ClassUtils.getSonClass(abstractClass);
		List<CommandName> commandNameList = new ArrayList<CommandName>();
		for (Class<?> c : classes) {
			CommandName commandName = null;
			try {
				commandName = (CommandName)Class.forName(c.getName()).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(commandNameList.size() > 0){
				commandNameList.get(commandNameList.size() - 1).setNext(commandName);
			}
			commandNameList.add(commandName);
		}
		return commandNameList;
	}
}
