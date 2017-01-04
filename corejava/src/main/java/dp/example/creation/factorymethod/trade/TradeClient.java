/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.factorymethod.trade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 工厂方法模式+策略模式
 * @author YZhi
 * @since 1.0
 */
public class TradeClient {
	/**
	 *
	 */
	@Test
	public void testTrade(){
		Card card = initIC();
		showCard(card);
		boolean flag = true;
		while (flag) {
			Trade trade = createTrade();
			DeductionFacade.deduct(card, trade);
			System.out.println(trade.getTradeNo());
			System.out.println(trade.getAmount()/100.0);
			showCard(card);
			System.out.println("是否退出?(Y/N)");
			if(getInput().equalsIgnoreCase("y")){
				flag = false;
			}
		}
	}

	/**
	 *
	 * @return
	 */
	private Trade createTrade() {
		Trade trade = new Trade();
		trade.setTradeNo(getInput());
		trade.setAmount(Integer.parseInt(getInput()));
		return trade;
	}

	/**
	 *
	 * @param card
	 */
	private void showCard(Card card) {
		System.out.println(card.getCardNo());
		System.out.println(card.getSteadyMoney());
		System.out.println(card.getFreeMoney());
	}

	/**
	 *
	 * @return
	 */
	private Card initIC() {
		Card card = new Card();
		card.setCardNo("1000101010");
		card.setFreeMoney(100000);
		card.setSteadyMoney(80000);
		return card;
	}
	
	private static String getInput(){
		String str = "";
		try {
			str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (Exception e) {
		}
		return str;
	}
}
