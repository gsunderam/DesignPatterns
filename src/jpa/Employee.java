package jpa;

import javax.persistence.*;
import java.io.Serializable;
/**
 * User: gsunderam
 * Date: Jan 9, 2015
 */
@EntityListeners({EmpListener.class})
@Entity(name = "EMPLOYEE")
public class Employee implements Serializable {
  @Id
  @Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "ADDR", nullable = false)
  private String addr;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department", nullable = false)
	private Department department;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

  public Employee(){}

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

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
