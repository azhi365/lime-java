/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:43:17
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.chainofresponsibility.women;

/**
 * 丈夫
 * @author YZhi
 * @since 1.0
 */
public class Husband extends Handler {
	public Husband(){
		super(Handler.HUSBAND_LEVEL_REQUEST);
	}

	/* (non-Javadoc)
	 * @see behavior.chainofresponsibility.example.women.Handler#response(behavior.chainofresponsibility.example.women.IWomen)
	 */
	@Override
	protected void response(IWomen women) {
		System.out.println(women.getRequest());
		System.out.println("husband agree");
	}
	
}
