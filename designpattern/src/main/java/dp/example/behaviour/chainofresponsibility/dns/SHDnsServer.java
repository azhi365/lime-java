/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.chainofresponsibility.dns;

/**
 * 上海DNS
 * @author YZhi
 * @since 1.0
 */
public class SHDnsServer extends DnsServer {
	/* (non-Javadoc)
	 * @see dp.example.behaviour.chainofresponsibility.dns.DnsServer#echo(java.lang.String)
	 */
	@Override
	protected Recorder echo(String domain) {
		Recorder recorder = super.echo(domain);
		recorder.setOwner("SH");
		return recorder;
	}
	
	/* (non-Javadoc)
	 * @see dp.example.behaviour.chainofresponsibility.dns.DnsServer#isLocal(java.lang.String)
	 */
	@Override
	protected boolean isLocal(String domain) {
		return domain.endsWith("sh.cn");
	}

}
