package dp.behaviour.memento;

/**
 * 发起人角色
 * @author YZhi
 * @since 1.0
 */
public class Originator {
	private String state = "A";
	public Memento createMemento(){
		return new Memento(this.state);
	}
	public void restoreMemento(Memento memento){
		this.setState(memento.getState());
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
