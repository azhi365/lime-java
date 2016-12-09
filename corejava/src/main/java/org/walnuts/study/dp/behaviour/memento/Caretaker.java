package org.walnuts.study.dp.behaviour.memento;

/**
 * 备忘录管理员角色
 * @author YZhi
 * @since 1.0
 */
public class Caretaker {
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
