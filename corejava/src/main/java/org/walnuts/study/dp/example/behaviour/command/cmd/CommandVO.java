/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.cmd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 命令对象
 * @author YZhi
 * @since 1.0
 */
public class CommandVO {
	public final static String DIVIE_FLAG = " ";
	public final static String PREFIX = "-";
	private String commandName = "";
	private ArrayList<String> paramList = new ArrayList<String>();
	private ArrayList<String> dataList = new ArrayList<String>();
	
	public CommandVO(String command) {
		if(command != null && command.length() != 0){
			String[] complex = command.split(CommandVO.DIVIE_FLAG);
			this.commandName = complex[0];
			for (int i = 0; i < complex.length; i++) {
				String str = complex[i];
				if(str.indexOf(CommandVO.PREFIX) == 0){
					this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
				}else {
					this.dataList.add(str.trim());
				}
			}
		}else {
			System.out.println("命令解析失败，必须传递一个命令才能执行!");
		}
	}
	
	public String getCommandName(){
		return this.commandName;
	}
	public ArrayList<String> getParam(){
		if(this.paramList.size() == 0){
			this.paramList.add(" ");
		}
		//去除重复的命令选项
		return new ArrayList<String>(new HashSet<String>(this.paramList));
	}
	
	public ArrayList<String> getData(){
		return this.dataList;
	}
	public String formatData(){
		String str = "";
		List<String> list = this.getData();
		for (String string : list) {
			str += string;
		}
		return str;
	}
}