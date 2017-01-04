/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.chainofresponsibility.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 责任链模式VS观察者模式
 * 责任链模式中传递的消息对象一般不变，而观察者模式中的消息对象可以自由变化
 * 责任链模式中上下级没有什么关系，而观察者模式中任意两个相邻节点都是一个牢固的独立团体
 * 责任链模式中消息传递方向是单一的、固定的，而观察者模式则灵活性很大，也可以跳跃传递
 * @author YZhi
 * @since 1.0
 */
public class DnsClient {
	/**
	 * 责任链模式DNS
	 */
	@Test
	public void testDnsChianOfResponsibility(){
		DnsServer sh = new SHDnsServer();
		DnsServer china = new ChinaTopDnsServer();
		DnsServer top = new TopDnsServer();
		china.setUpperDnsServer(top);
		sh.setUpperDnsServer(china);
		while (true){
			try {
				String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				if(domain.equalsIgnoreCase("n")){
					return;
				}
				Recorder recorder = sh.resolve(domain);
				System.out.println(recorder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *观察者模式
	 */
	@Test
	public void testDnsObserver() {
		dp.example.behaviour.observer.dns.DnsServer sh = new dp.example.behaviour.observer.dns.SHDnsServer();
		dp.example.behaviour.observer.dns.ChinaTopDnsServer china = new dp.example.behaviour.observer.dns.ChinaTopDnsServer();
		dp.example.behaviour.observer.dns.TopDnsServer top = new dp.example.behaviour.observer.dns.TopDnsServer();
		china.setUpperServer(top);
		sh.setUpperServer(china);
		while (true){
			try {
				String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				if(domain.equalsIgnoreCase("n")){
					return;
				}
				Recorder recorder = new Recorder();
				recorder.setDomian(domain);
				sh.update(null, recorder);
				System.out.println(recorder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
