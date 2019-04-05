package eu.ensup.projetmockdao.domaine;

public class Person {
	
	private String FirstName;
	private String LastName;
	private int Id;

	public String getFirstName() {
		return FirstName;
	}

	@Override
	public String toString() {
		return "Person [FirstName=" + FirstName + ", LastName=" + LastName + ", Id=" + Id + "]";
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
