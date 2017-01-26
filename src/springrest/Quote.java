package springrest;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: gsunderam
 * Date: Jul 19, 2013
 */
@Component
@XmlRootElement
public class Quote {
  private String name;
  private long id;

  public Quote(){}

  public Quote(long id, String name) {
    this.name = name;
    this.id = id;
  }

  @XmlElement
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElement
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String toString() {
    return "Quote name: " + name + " Value: " + id;
  }
}
