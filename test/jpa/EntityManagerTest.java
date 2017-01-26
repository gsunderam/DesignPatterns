package test.test.jpa;

import jpa.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 9, 2015
 */
public class EntityManagerTest {
  public static void main(String[] args) {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("testjpa");
    stdout("EMF is : " + emf);
    EntityManager em = emf.createEntityManager();
    stdout("EM is : " + em);
    EntityTransaction userTran = em.getTransaction();

    /** Transaction is required to persist */
    userTran.begin();
//    Employee emp = new Employee();
    Employee emp = em.find(Employee.class, 51);
    stdout("Emp found is " + emp);
//    emp.setName("John");
    emp.setAddr("1001 Springfield pasrkway, Chicago, IL");

    //em.persist(emp);
    em.merge(emp);
    userTran.commit();
    em.close();
    emf.close();
  }
}
