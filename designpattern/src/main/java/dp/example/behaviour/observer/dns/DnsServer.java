/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.observer.dns;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import dp.example.behaviour.chainofresponsibility.dns.Recorder;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public abstract class DnsServer extends Observable implements Observer {

	protected abstract boolean isLocal(Recorder recorder);
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Recorder recorder =  (Recorder)arg;
		if(this.isLocal(recorder)){
			recorder.setIp(this.genIpAddress());
		}else {
			this.responseFromUpperServer(recorder);
		}
		sign(recorder);
	}
	
	/**
	 * 作为被观察者，允许增加观察者
	 *
	 * @param dnsServer
	 */
	public void setUpperServer(DnsServer dnsServer){
		super.deleteObservers();
		super.addObserver(dnsServer);
	}
	
	protected abstract void sign(Recorder recorder);
	
	/**
	 *向父DNS请求解析,即通知观察者
	 * @param recorder
	 */
	private void responseFromUpperServer(Recorder recorder){
		super.setChanged();
		super.notifyObservers(recorder);
	}
	
	/**
	 *随机生产一个IP地址
	 * @return
	 */
	private String genIpAddress(){
		Random random = new Random();
		String ip = "";
		for (int i = 0; i < 4; i++) {
			ip += random.nextInt(255) +  ".";
		}
		ip = ip.substring(0,ip.length() -1);
		return ip;
	}	

}
