/**
 * 
 * @author yzhi
 * @date 2012-1-19 上午09:17:00
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.proxy.gameplayer;
/**
 * 游戏者
 * @author YZhi
 * @since 1.0
 */
public class GamePlayer implements IGamePlayer {
	private String name = "";
	
	private IGamePlayer proxy;
	/**
	 * 强制代理
	 * @param name
	 */
	public GamePlayer(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * 普通代理
	 * 
	 * @param gamePlayer
	 * @param name
	 */
	public GamePlayer(IGamePlayer gamePlayer,String name){
		if(gamePlayer == null){
			throw new RuntimeException("can not create a gameplayer");
		}else {
			this.name = name;
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see structure.proxy.example.gameplayer.IGamePlayer#getProxy()
	 */
	@Override
	public IGamePlayer getProxy() {
		this.proxy = new GamePlayerProxy(this.name);
		return this;
	}

	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		System.out.println(this.name + "KillBoss");
	}
	
	/**
	 *检查是否是代理访问
	 * @return
	 */
	public boolean isProxy(){
		if(this.proxy == null){
			return false;
		}else {
			return true;
		}
	}
	
	public void killBossInForceProxy(){
		if(this.isProxy()){
			System.out.println(this.name + "KillBoss");
		}else {
			System.out.println("can not accessed");
		}
	}
	
	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String password) {
		System.out.println("the " + user + this.name + "login successed");
	}
	/* (non-Javadoc)
	 * @see structure.proxy.example.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		System.out.println(this.name + " upgraded");
	}
	
}
