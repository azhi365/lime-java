/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:58:15
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.facade.Letter;

/**
 * 现代化邮局
 * @author YZhi
 * @since 1.0
 */
public class ModenPostOffice {
	private ILetterProcess letterProcess = new LetterProcessImpl();
	private Police police = new Police();
	public void sendLetter(String context,String address){
		letterProcess.writerContext(context);
		letterProcess.fillEnvelope(address);
		police.checkLetter(letterProcess);
		letterProcess.letterIntoEnvelope();
		letterProcess.setdLetter();
	}
}
