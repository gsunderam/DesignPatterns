package jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: gsunderam
 * Date: Jan 9, 2015
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "FTE")
@Entity(name = "EMPLOYEE")
public class EmployeeSingle implements Serializable {
  @Id
  @Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "ADDR", nullable = false)
  private String addr;

  @Column(name = "EMP_TYPE", nullable = false)
  private String empType;

  public EmployeeSingle(){}

  public String getEmpType() {
    return empType;
  }

  public void setEmpType(String empType) {
    this.empType = empType;
  }

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

}
