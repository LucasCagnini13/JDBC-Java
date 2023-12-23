package model.Entities;

import java.util.Date;
import java.util.Objects;

public class Seller {
	
	private int id;
	private String name;
	private String  email;
	private Date birthDate;
	private double BaseSalary;
	
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getBaseSalary() {
		return BaseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		BaseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Seller(int id, String name, String email, Date birthDate, double baseSalary, Department department) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		BaseSalary = baseSalary;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", BaseSalary="
				+ BaseSalary + ", department=" + department + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return id == other.id;
	}
}
