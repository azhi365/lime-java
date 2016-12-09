/**
 * @author yzhi
 * @date 2012-1-29 下午02:56:56
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.facade.Letter;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class LetterProcessImpl implements ILetterProcess {

	/* (non-Javadoc)
	 * @see structure.facade.example.Letter.ILetterProcess#fillEnvelope(java.lang.String)
	 */
	@Override
	public void fillEnvelope(String address) {
		System.out.println("fillEnvelope");
	}

	/* (non-Javadoc)
	 * @see structure.facade.example.Letter.ILetterProcess#letterIntoEnvelope()
	 */
	@Override
	public void letterIntoEnvelope() {
		System.out.println("letterIntoEnvelope");
	}

	/* (non-Javadoc)
	 * @see structure.facade.example.Letter.ILetterProcess#setdLetter()
	 */
	@Override
	public void setdLetter() {
		System.out.println("setdLetter");
	}

	/* (non-Javadoc)
	 * @see structure.facade.example.Letter.ILetterProcess#writerContext(java.lang.String)
	 */
	@Override
	public void writerContext(String context) {
		System.out.println("writerContext");
	}

}
