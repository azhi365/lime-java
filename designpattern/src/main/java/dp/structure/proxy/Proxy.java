package dp.structure.proxy;

/**
 * 代理类
 * @author YZhi
 * @since 1.0
 */
public class Proxy implements Subject {
	private Subject subject = null;
	public Proxy() {
		this.subject = new RealSubjecOne();
	}
	
	public Proxy(Subject subject) {
		this.subject = subject;
	}
	
	
	
	/* (non-Javadoc)
	 * @see structure.proxy.Subject#request()
	 */
	@Override
	public void request() {
		this.before();
		this.subject.request();
		this.after();
	}

	@Override
	public void methodA() {
		this.subject.methodA();
	}

	@Override
	public void methodB() {
		this.subject.methodB();
	}
	
	public void method(){
		System.out.println("method in Proxy");
	}
	
	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}

}
