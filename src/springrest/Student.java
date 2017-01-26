package springrest;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

import javax.annotation.PostConstruct;
import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import java.util.List;

/**
 * User: gsunderam
 * Date: Oct 8, 2013
 *
 * @version 2 Modified
 * Date: Jul 16, 2015
 * Added JMX Support
 */
@ManagedResource(objectName="bean:name=student", description="Student Properties")
public class Student implements NotificationPublisherAware {
  private long id;
  private String name;
  private String company;
  private double salary;
	private NotificationPublisher publisher;

	private double oldsalary;

  private List<String> list;

  @PostConstruct
  public void afterInitialization() {
    System.out.println("list is " + list);
  }

  public long getId() { 
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ManagedAttribute(description="Student Name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManagedAttribute(description="company")
  public String getCompany() {
    return company;
  }

  @ManagedAttribute(description="Company Attribute")
  public void setCompany(String company) {
    this.company = company;
  }

  @ManagedAttribute(description="Salary")
  public double getSalary() {
    return salary;
  }

  @ManagedAttribute(description="Salary Attribute") 
  public void setSalary(double salary) {
		oldsalary = this.salary;
    this.salary = salary;
  }

	@ManagedOperation
	public double diffSalary() {
		double diff = salary - oldsalary;
		Notification n = new AttributeChangeNotification(this,
                                1, System.currentTimeMillis(),
                                "salary changed", "salary", "double",
						diff, this.salary);
		this.publisher.sendNotification(n);

		return diff;
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher publisher) {
		this.publisher = publisher;
	}
}
