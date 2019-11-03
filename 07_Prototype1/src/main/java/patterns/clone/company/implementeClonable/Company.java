package patterns.clone.company.implementeClonable;

import java.util.ArrayList;
import java.util.List;

public class Company implements Cloneable{
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	public Company clone() {
		try {
			Company c = (Company) super.clone();
			c.employees = new ArrayList<>(employees);
//		c.employees = new ArrayList<>();;
//		for (Employee e : employees ) {
//			c.addEmployee(e.clone());
//		}
		} catch (CloneNotSupportedException err){

		}

	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public int getSize() {
		return employees.size();
	}

	public void addEmployee(Employee p) {
		this.employees.add(p);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			Company c = (Company) o;
			return name.equals(c.name) && employees.equals(c.employees);
		} else {
			return false;
		}
	}

	@Override
	public Company clone() {
		// TODO Task 2&3: implement method clone
		return new Company(this);
	}
}
