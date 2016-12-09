/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:32:42
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.templete.hummer;

/**
 * A型号悍马模型
 * @author YZhi
 * @since 1.0
 */
public class HummerAModel extends HummerModel {
	private boolean alarmFlag = true;
	
	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#alarm()
	 */
	@Override
	public void alarm() {
		System.out.println("HummerA alarm");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#engineBoom()
	 */
	@Override
	public void engineBoom() {
		System.out.println("HummerA engineBoom");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#start()
	 */
	@Override
	public void start() {
		System.out.println("HummerA start");
	}

	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#stop()
	 */
	@Override
	public void stop() {
		System.out.println("HummerA stop");
	}
	
	/* (non-Javadoc)
	 * @see behaviour.templete.example.hummer.HummerModel#isAlarm()
	 */
	@Override
	protected boolean isAlarm() {
		return this.alarmFlag;
	}

	public void setAlarm(boolean isAlarm){
		this.alarmFlag = isAlarm;
	}
	

}
