/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:43:41
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.observer.hanfei;

/**
 * 刘斯
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class LiuSi implements Observer {

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.Observer#update(java.lang.String)
	 */
	@Override
	public void update(String context) {
		System.out.println("LiuSi: " + context);
	}

}
