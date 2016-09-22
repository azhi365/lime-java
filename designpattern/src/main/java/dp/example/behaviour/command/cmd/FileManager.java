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
 * 文件管理类
 * @author YZhi
 * @since 1.0
 */
public class FileManager {
	public static String ls(String path){
		return "file1\nfile2\nfile3\nfile4";
	}
	
	public static String ls_l(String path){
		String str = "drw-rw-rw root system 1024 2009-8-20 10:23 file1";
		return str;
	}

	public static String ls_a(String path){
		String str = ".\n..\nfile1\nfile2";
		return str;
	}	
}
