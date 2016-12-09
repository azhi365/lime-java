package org.walnuts.study.dp.behaviour.templete;

/**
 * 具体模板类B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteClassB extends AbstractClass {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	protected void methodA() {
		System.out.println("methodA in ConcreteClassB");
	}

	@Override
	protected void methodB() {
		System.out.println("methodB in ConcreteClassB");
	}

}
