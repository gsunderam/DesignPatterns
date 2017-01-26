package jpa;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 10, 2015
 */
 public class EmpListener {
    @PreUpdate
    public void preUpdate(Employee e) {
      stdout("In pre update");
    }

    @PostUpdate
    public void postUpdate(Employee e) {
      stdout("In post update");
    }
  }
