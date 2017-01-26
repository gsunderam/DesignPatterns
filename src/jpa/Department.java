package jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * User: gsunderam
 * Date: Jan 16, 2015
 */
@Entity
public class Department {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department")
	private Collection<Employee> employees;

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

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
