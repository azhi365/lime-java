package dp.behaviour.state;

/**
 * 具体环境
 * @author YZhi
 * @since 1.0
 */
public class Context {
	public final static State STATEA = new ConcreteStateA();
	public final static State STATEB = new ConcreteStateB();
	private State currentState;
	public State getCurrentState() {
		return this.currentState;
	}
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
		this.currentState.setContext(this);
	}
	
	public void handleA() {
		this.currentState.handleA();
	}
	
	public void handleB(){
		this.currentState.handleB();
	}
	
	
}
