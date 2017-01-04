/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:41:08
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.observer.hanfei;

/**
 * 李斯
 * @author YZhi
 * @since 1.0
 */
public class LiSi implements Observer {

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.Observer#update(java.lang.String)
	 */
	@Override
	public void update(String context) {
		System.out.println("lisi: " + context);
	}

}
