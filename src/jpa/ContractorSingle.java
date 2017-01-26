package jpa;

import javax.persistence.*;

/**
 * User: gsunderam
 * Date: Jan 10, 2015
 *
 * This is the power of inheritance. By having one class per table heirarchy, application server memory footprint
 * is reduced
 */
@Entity(name = "CONTRACTOR")
@DiscriminatorValue(value = "CONTRACT")
//@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class ContractorSingle extends EmployeeSingle {

  @Column(name = "RATE")
  private int rate;

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }
}
