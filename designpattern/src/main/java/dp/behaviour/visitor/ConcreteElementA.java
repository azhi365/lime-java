package dp.behaviour.visitor;

/**
 * 具体元素A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteElementA extends Element {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void method() {
		System.out.println("method in COncreteElementA");
	}

}
