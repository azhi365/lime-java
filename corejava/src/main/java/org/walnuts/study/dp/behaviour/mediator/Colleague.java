package org.walnuts.study.dp.behaviour.mediator;

/**
 * 抽象同事类
 * @author YZhi
 * @since 1.0
 */
public abstract class Colleague {
	protected Mediator mediator;
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
}
