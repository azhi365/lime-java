/**
 * @author yzhi
 * @date 2012-1-19 上午09:24:06
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.proxy.gameplayer;

/**
 * 代练者
 * @author YZhi
 * @since 1.0
 */
public class GamePlayerProxy implements IGamePlayer,IProxy {
	private IGamePlayer gamePlayer = null;
	public GamePlayerProxy(IGamePlayer gamePlayer){
		this.gamePlayer = gamePlayer;
	}
	
	public GamePlayerProxy(String name){
		try {
			gamePlayer = new GamePlayer(this,name);
		} catch (Exception e) {
			
		}
	}
	
	/* (non-Javadoc)
	 * @see structure.proxy.example.gameplayer.IGamePlayer#getProxy()
	 */
	@Override
	public IGamePlayer getProxy() {
		return this;
	}

	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		this.gamePlayer.killBoss();
	}

	
	/* (non-Javadoc)
	 * @see structure.proxy.example.gameplayer.IGamePlayer#killBossInForceProxy()
	 */
	@Override
	public void killBossInForceProxy() {
		this.gamePlayer.killBossInForceProxy();
	}

	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String password) {
		this.gamePlayer.login(user, password);
	}

	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		this.gamePlayer.upgrade();
		this.count();
	}

	/* (non-Javadoc)
	 * @see structure.proxy.example.gameplayer.IProxy#count()
	 */
	@Override
	public void count() {
		System.out.println("count is 100");
	}
}
