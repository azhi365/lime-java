package org.walnuts.study.concurrency.Appendix.recipe01;

public final class PersonImmutable {
	
	final private String firstName;
	final private String lastName;
	
	public PersonImmutable (String firstName, String lastName, String address) {
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}
}
