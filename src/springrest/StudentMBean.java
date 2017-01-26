package springrest;

/**
 * User: gsunderam
 * Date: Oct 8, 2013
 */
public interface StudentMBean {
  public String getName();

  public String getCompany();

  public void setCompany(String company);

  public double getSalary();

  public void setSalary(double salary);
}
