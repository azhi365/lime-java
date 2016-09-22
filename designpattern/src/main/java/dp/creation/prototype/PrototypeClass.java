package dp.creation.prototype;

/**
 * 原型模式通用代码
 * @author YZhi
 * @since 1.0
 */
public class PrototypeClass implements Cloneable {
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected PrototypeClass clone() throws CloneNotSupportedException {
		PrototypeClass prototypeClass = null;
		try {
			prototypeClass = (PrototypeClass)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototypeClass;
	}
}
