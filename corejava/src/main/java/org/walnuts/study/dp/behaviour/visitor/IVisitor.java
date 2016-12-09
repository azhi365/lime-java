package org.walnuts.study.dp.behaviour.visitor;

/**
 * 抽象访问者
 * @author YZhi
 * @since 1.0
 */
public interface IVisitor {
	public void visit(ConcreteElementA ceA);
	public void visit(ConcreteElementB ceB);
}
