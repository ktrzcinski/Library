package data;

import java.io.Serializable;

public abstract class User implements Serializable {
	private static final long serialVersionUID = 3582734987248230L;
	
	private String firstName;
	private String lastName;
	private String ppsNo;
	
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
	
	public String getPpsNo() {
		return ppsNo;
	}
	
	public void setPpsNo(String ppsNo) {
		this.ppsNo = ppsNo;
	}

	//Constructor
	public User(String firstName, String lastName, String ppsNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ppsNo = ppsNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ppsNo == null) ? 0 : ppsNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ppsNo == null) {
			if (other.ppsNo != null)
				return false;
		} else if (!ppsNo.equals(other.ppsNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " - " + ppsNo;
	}
}
