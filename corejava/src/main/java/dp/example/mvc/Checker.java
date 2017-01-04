/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.mvc;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Checker implements Observer {
	private IXmlValidate validate;
	String xmlPath;
	/**
	 * 
	 * @param validate
	 */
	public Checker(IXmlValidate validate) {
		this.validate = validate;
	}
	
	/**
	 * 
	 */
	public Checker() {
		super();
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	public boolean check(){
		return validate.validate(xmlPath);
	}
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		arg = check();
	}
	
}
