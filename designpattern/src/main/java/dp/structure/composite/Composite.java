package dp.structure.composite;

import java.util.ArrayList;

/**
 * 树枝构件
 * @author YZhi
 * @since 1.0
 */
public class Composite extends Component {
	private ArrayList<Component> components = new ArrayList<Component>();
	
	public void add(Component component) {
		this.components.add(component);
	}
	
	public void remove(Component component){
		this.components.remove(component);
	}
	
	public ArrayList<Component> getChildren() {
		return this.components;
	}

}
