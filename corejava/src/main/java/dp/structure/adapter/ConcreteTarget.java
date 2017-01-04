package dp.structure.adapter;

/**
 * 目标角色实现
 * @author YZhi
 * @since 1.0
 */
public class ConcreteTarget implements Target {

	@Override
	public void request() {
		System.out.println("method in request");
	}

}
