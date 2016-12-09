/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:33:46
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.chainofresponsibility.women;

/**
 * 古代妇女
 * @author YZhi
 * @since 1.0
 */
public class Women implements IWomen {
	private int type = 0;
	private String request = " request";
	
	public Women(int type,String request){
		this.type = type;
		switch (this.type) {
			case 1 :
				this.request = "daughter" + request;
				break;
			case 2 :
				this.request = "wife" + request;
				break;
			case 3 :
				this.request = "mother" + request;
				break;
			default :
				break;
		}
		
	}
	/* (non-Javadoc)
	 * @see behavior.chainofresponsibility.example.women.IWomen#getRequest()
	 */
	@Override
	public String getRequest() {
		return this.request;
	}

	/* (non-Javadoc)
	 * @see behavior.chainofresponsibility.example.women.IWomen#getType()
	 */
	@Override
	public int getType() {
		return this.type;
	}

}
