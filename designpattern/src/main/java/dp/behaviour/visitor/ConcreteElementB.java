package dp.behaviour.visitor;

/**
 * 具体元素B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteElementB extends Element {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void method() {
		System.out.println("method in ConcreteElementB");
	}

}
