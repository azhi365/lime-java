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
 * 命令配置对象
 * @author YZhi
 * @since 1.0
 */
public enum CommandEnum {
	ls("dp.example.behaviour.command.LSCommand"),
	df("dp.example.behaviour.command.DFCommand");
	private String value = "";

	/**
	 * 
	 * @param value
	 */
	private CommandEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static List<String> getNames(){
		CommandEnum[] commandEnums = CommandEnum.values();
		List<String> names = new ArrayList<String>();
		for (CommandEnum c : commandEnums) {
			names.add(c.name());
		}
		return names;
	}
}
