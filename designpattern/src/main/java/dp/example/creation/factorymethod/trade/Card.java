/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.factorymethod.trade;

/**
 * IC卡类
 * @author YZhi
 * @since 1.0
 */
public class Card {
	private String cardNo = "";
	private int steadyMoney = 0;
	private int freeMoney = 0;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getSteadyMoney() {
		return steadyMoney;
	}
	public void setSteadyMoney(int steadyMoney) {
		this.steadyMoney = steadyMoney;
	}
	public int getFreeMoney() {
		return freeMoney;
	}
	public void setFreeMoney(int freeMoney) {
		this.freeMoney = freeMoney;
	}
	
}
