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
 * 命令分发
 * @author YZhi
 * @since 1.0
 */
public class Invoker {
	public String exec(String command){
		String result = "";
		CommandVO vo = new CommandVO(command);
		if(CommandEnum.getNames().contains(vo.getCommandName())){
			String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
			Command c;
			try {
				c = (Command)Class.forName(className).newInstance();
				result = c.execute(vo);
			} catch (Exception e) {
			}
		}else {
			return "无法执行命令，请检查命令的格式";
		}
		return result;
	}
}
