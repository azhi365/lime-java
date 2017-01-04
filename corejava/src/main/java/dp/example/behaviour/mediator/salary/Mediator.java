/**
 * 

 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.mediator.salary;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Mediator extends AbsMediator {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#down(dp.example.behaviour.mediator.salary.ISalary)
	 */
	@Override
	public void down(ISalary salary) {
		downSalary();
		downTax();
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#down(dp.example.behaviour.mediator.salary.ITax)
	 */
	@Override
	public void down(ITax tax) {
		downTax();
		upSalary();
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#down(dp.example.behaviour.mediator.salary.IPosition)
	 */
	@Override
	public void down(IPosition position) {
		downPosition();
		downSalary();
		downTax();
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#up(dp.example.behaviour.mediator.salary.ISalary)
	 */
	@Override
	public void up(ISalary salary) {
		upSalary();
		upTax();
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#up(dp.example.behaviour.mediator.salary.ITax)
	 */
	@Override
	public void up(ITax tax) {
		upTax();
		downSalary();
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.AbsMediator#up(dp.example.behaviour.mediator.salary.IPosition)
	 */
	@Override
	public void up(IPosition position) {
		upPosition();
		upSalary();
		upTax();
	}
	
	private void upSalary(){
		System.out.println("upSalary");
	}
	private void upTax(){
		System.out.println("upTax");
	}
	private void upPosition(){
		System.out.println("upPosition");
	}
	private void downSalary(){
		System.out.println("downSalary");
	}
	private void downTax(){
		System.out.println("downTax");
	}	
	private void downPosition(){
		System.out.println("downPosition");
	}
}
