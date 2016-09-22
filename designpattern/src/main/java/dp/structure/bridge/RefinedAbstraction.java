package dp.structure.bridge;

/**
 * 具体抽象化角色
 * @author YZhi
 * @since 1.0
 */
public class RefinedAbstraction extends Abstraction {
	
	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	public void methodC() {
		super.methodC();
		super.getImplementor().methodB();
	}
}
