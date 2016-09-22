package dp.structure.proxy;

/**
 * 真实主题2类
 * @author YZhi
 * @since 1.0
 */
public class RealSubjectTwo implements Subject {
	
	
	/* (non-Javadoc)
	 * @see structure.proxy.Subject#request()
	 */
	@Override
	public void request() {
		System.out.println("request implemented in RealSubjectTwo");
	}

	@Override
	public void methodA() {
		System.out.println("methodA implemented in RealSubjectTwo");

	}

	@Override
	public void methodB() {
		System.out.println("methodB implemented in RealSubjectTwo");
	}

}
