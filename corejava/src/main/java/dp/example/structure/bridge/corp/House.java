/**
 * @author yzhi
 * @date 2012-1-30 上午10:52:58
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.bridge.corp;

/**
 * 房子
 * @author YZhi
 * @since 1.0
 */
public class House extends Product {

	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.corp.Product#beProducted()
	 */
	@Override
	public void beProducted() {
		System.out.println("house has producted");
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.corp.Product#beSelled()
	 */
	@Override
	public void beSelled() {
		System.out.println("house has selled");	
	}

}
