/**
 * 
 * @author yzhi
 * @date 2012-1-19 上午09:21:20
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.proxy.gameplayer;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * @author YZhi
 * @since 1.0
 */
public class GamePlayerClient  {	
	@Test
	public void testSubject(){
		IGamePlayer player = new GamePlayer("zhang san");
		player.login("zhang san", "pwd");
		player.killBoss();
		player.upgrade();
		System.out.println("----------------");
	}
	
	@Test
	public void testProxy(){
		GamePlayerProxy proxy = new GamePlayerProxy(new GamePlayer("Zhang san"));
		proxy.login("Zhang san", "pwd");
		proxy.killBoss();
		proxy.upgrade();
		System.out.println("----------------");
	}
	
	@Test
	public void testGenericProxy(){
		IGamePlayer proxy = new GamePlayerProxy("zhang san");
		proxy.login("zhang san", "pwd");
		proxy.killBoss();
		proxy.upgrade();
		System.out.println("------------------");
	}
	
	@Test
	public void testForceProxy(){
		IGamePlayer player = new GamePlayer("zhang san");
		player.killBossInForceProxy();
		
		IGamePlayer proxy = new GamePlayerProxy(player);
		proxy.killBossInForceProxy();
		
		player = new GamePlayer("zhang san");
		proxy = player.getProxy();
		proxy.killBossInForceProxy();
	}
	
	@Test
	public void testProxyIH(){
		IGamePlayer player = new GamePlayer("Zhang san");
		InvocationHandler handler = new GamePlayerIH(player);
		ClassLoader cl = player.getClass().getClassLoader();
		IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
		proxy.login("A", "P");
		proxy.killBoss();
		proxy.upgrade();
	}
}
