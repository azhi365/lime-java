package dp.behaviour.memento;

/**
 * 备忘录角色
 * 
 * @author YZhi
 * @since 1.0
 */
public class Memento {
	private String state = "A";
	public Memento(String state){
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
