package dp.behaviour.mediator;

/**
 * 具体同事类A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}
	public void selfMethod() {
		System.out.println("selfMethod in ConcreteColleagueA");
	}
	
	public void depMethod() {
		super.mediator.methodA();
	}
}
