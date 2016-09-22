/**
 * @author yzhi
 * @date 2012-1-30 上午10:12:50
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.flyweight.sign;

/**
 * 多线程场景
 * @author YZhi
 * @since 1.0
 */
public class MultiThread extends Thread {
	private SignInfo signInfo;
	public MultiThread(SignInfo signInfo){
		this.signInfo = signInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		if(!signInfo.getId().equals(signInfo.getLocation())){
			System.out.println("id: " + signInfo.getId());
			System.out.println("address: " + signInfo.getLocation());
			System.out.println("thread unsafe");
		}
	}
}
