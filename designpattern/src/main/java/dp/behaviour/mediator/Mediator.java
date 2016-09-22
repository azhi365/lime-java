package dp.behaviour.mediator;

/**
 * 通用抽象中介者
 * @author YZhi
 * @since 1.0
 */
public abstract class Mediator {
	protected ConcreteColleagueA cA;
	protected ConcreteColleagueB cB;
	
	public abstract void methodA();
	public abstract void mehtodB();
	
	public ConcreteColleagueA getcA() {
		return cA;
	}
	public void setcA(ConcreteColleagueA cA) {
		this.cA = cA;
	}
	public ConcreteColleagueB getcB() {
		return cB;
	}
	public void setcB(ConcreteColleagueB cB) {
		this.cB = cB;
	}
	
	
}
