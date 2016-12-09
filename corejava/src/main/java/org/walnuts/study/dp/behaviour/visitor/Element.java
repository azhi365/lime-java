package org.walnuts.study.dp.behaviour.visitor;

/**
 * 抽象元素
 * @author YZhi
 * @since 1.0
 */
public abstract class Element {
	public abstract void method();
	public abstract void accept(IVisitor visitor);
}
