/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.chainofresponsibility.dns;

import java.util.Random;

/**
 * 抽象DNS服务器
 * @author YZhi
 * @since 1.0
 */
public abstract class DnsServer {
	private DnsServer upperDnsServer;
	
	protected abstract boolean isLocal(String domain);
	
	public final Recorder resolve(String domain){
		Recorder recorder = null;
		if(this.isLocal(domain)){
			recorder = this.echo(domain);
		}else {
			recorder = upperDnsServer.resolve(domain);
		}
		return recorder;
	}

	
	public void setUpperDnsServer(DnsServer upperDnsServer) {
		this.upperDnsServer = upperDnsServer;
	}
	
	protected Recorder echo(String domain){
		Recorder recorder = new Recorder();
		recorder.setDomian(domain);
		recorder.setIp(this.genIpAddress());
		return recorder;
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
