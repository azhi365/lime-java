/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:33:55
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.templete.hummer;

/**
 * B型号悍马模型
 * @author YZhi
 * @since 1.0
 */
public class HummerBModel extends HummerModel {

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#alarm()
	 */
	@Override
	public void alarm() {
		System.out.println("HummerB alarm");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#engineBoom()
	 */
	@Override
	public void engineBoom() {
		System.out.println("HummerB engineBoom");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#start()
	 */
	@Override
	public void start() {
		System.out.println("HummerB start");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#stop()
	 */
	@Override
	public void stop() {
		System.out.println("HummerB stop");
	}
	
	protected boolean isAlarm(){
		return false;
	}
}
