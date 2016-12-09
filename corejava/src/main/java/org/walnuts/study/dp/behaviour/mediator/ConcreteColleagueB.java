package org.walnuts.study.dp.behaviour.mediator;

/**
 * 具体同事类B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	
	public void selfMehtod(){
		System.out.println("selfMehtod in ConcreteColleagueB");
	}
	
	public void depMethod(){
		super.mediator.mehtodB();
	}
}
