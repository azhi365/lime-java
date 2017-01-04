package dp.behaviour.state;

/**
 * 抽象状态
 * @author YZhi
 * @since 1.0
 */
public abstract class State {
	protected Context context;
	
	public abstract void handleA();
	public abstract void handleB();
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
}
