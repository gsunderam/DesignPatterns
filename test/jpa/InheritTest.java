package test.test.jpa;

import jpa.ContractorSingle;
import jpa.EmployeeSingle;

import javax.persistence.*;

import java.util.List;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 10, 2015
 */
public class InheritTest {
  public static void main(String[] args) {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("testjpa");
    stdout("EMF is : " + emf);
    EntityManager em = emf.createEntityManager();
    stdout("EM is : " + em);
    EntityTransaction userTran = em.getTransaction();
    userTran.begin();
//    createEmployee(em);
//    createContractor(em);
    selectCustomer(em);
    userTran.commit();
  }

  private static void selectCustomer(EntityManager em) {
    Query query = em.createQuery("select emp from CONTRACTOR emp");
    List<ContractorSingle> resultList = query.getResultList();
    for (ContractorSingle cont : resultList) {
//      ContractorSingle cont = resultList.get(0);
      stdout("Name is " + cont.getName());
      stdout("Rate is " + cont.getRate());
    }
  }

  private static void createEmployee(EntityManager em) {
    EmployeeSingle emp = new EmployeeSingle();
    emp.setName("TPClass");
    emp.setAddr("901 E TablePerClass Dr,NY");
    emp.setEmpType("FTE");
    em.persist(emp);
  }

  private static void createContractor(EntityManager em) {
    ContractorSingle cont = new ContractorSingle();
    cont.setName("Raghu");
    cont.setAddr("457 TBL pkwy, MO 90787");
    cont.setEmpType("CONTRACT");
    cont.setRate(120);
    em.persist(cont);
  }
}
