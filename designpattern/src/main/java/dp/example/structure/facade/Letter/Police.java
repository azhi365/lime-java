/**
 * @author yzhi
 * @date 2012-1-29 下午02:59:39
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.facade.Letter;

/**
 * 信件检查类
 * @author YZhi
 * @since 1.0
 */
public class Police {
	public void checkLetter(ILetterProcess letterProcess){
		System.out.println(letterProcess + " has checked");
	}
}
