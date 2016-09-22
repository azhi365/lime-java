package dp.behaviour.visitor;

/**
 * 具体访问者
 * @author YZhi
 * @since 1.0
 */
public class Visitor implements IVisitor {

	@Override
	public void visit(ConcreteElementA ceA) {
		ceA.method();
	}

	@Override
	public void visit(ConcreteElementB ceB) {
		ceB.method();
	}

}
