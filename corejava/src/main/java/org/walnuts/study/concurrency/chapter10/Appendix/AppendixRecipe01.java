package org.walnuts.study.concurrency.chapter10.Appendix;

public class AppendixRecipe01 {

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

	public class PersonMutable {
		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}


}
