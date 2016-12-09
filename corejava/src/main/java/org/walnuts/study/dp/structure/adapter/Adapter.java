package org.walnuts.study.dp.structure.adapter;

/**
 * 适配器角色
 * @author YZhi
 * @since 1.0
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void request() {
		super.methodA();
	}
}
