package test.test.jpa;

import jpa.Employee;
import jpa.JpaEntityManagerFactory;
import jpa.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 17, 2015
 */
public class One2OneTest {
	public static void main(String[] args) {
    EntityManager em = JpaEntityManagerFactory.getEntityManager();
    EntityTransaction userTran = em.getTransaction();
		userTran.begin();

//		Role admin = new Role();
//		admin.setName("Administrator");
//		em.persist(admin);
//
//		Role dev = new Role();
//		dev.setName("Developer");
//		em.persist(dev);
//
//		Employee emp1 = new Employee();
//		emp1.setName("RoleAdmin");
//		emp1.setAddr("10 test addr, AZ 89890");
//		emp1.setRole(admin);
//		em.persist(emp1);
//
//		Employee emp2 = new Employee();
//		emp2.setName("RoleDeveloper");
//		emp2.setAddr("10 test addr, AZ 89890");
//		emp2.setRole(dev);
//		em.persist(emp2);

		 Employee adminEmp = em.find(Employee.class, 1001);
		 stdout(adminEmp.getRole().getName());

		 Role devRole = em.find(Role.class, 952);
		 stdout("Developer is " + devRole.getEmployee().getName());

		userTran.commit();
	}
}
