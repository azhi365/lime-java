/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.cmd;

/**
 * 磁盘管理
 * @author YZhi
 * @since 1.0
 */
public class DiskManager {
	public static String df(){
		return "/home";
	}
	public static String df_k(){
		return "/home /k";
	}
	public static String df_g(){
		return "/home /g";	
	}
}
