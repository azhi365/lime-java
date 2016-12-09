/**
 * @author yzhi
 * @date 2012-1-29 下午02:55:21
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.facade.Letter;

/**
 * 写信过程接口
 * @author YZhi
 * @since 1.0
 */
public interface ILetterProcess {
	public void writerContext(String context);
	public void fillEnvelope(String address);
	public void letterIntoEnvelope();
	public void setdLetter();
}
