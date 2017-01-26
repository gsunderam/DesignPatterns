package test.test.jpa;

import jpa.Department;
import jpa.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Collection;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jan 17, 2015
 */
public class Many2OneTest {
	public static void main(String[] args) {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("testjpa");
    stdout("EMF is : " + emf);
    EntityManager em = emf.createEntityManager();
    stdout("EM is : " + em);
    EntityTransaction userTran = em.getTransaction();
//		userTran.begin();

//		Department fin = new Department();
//		fin.setName("Finance");
//
//		Department acc = new Department();
//		acc.setName("Accounts");
//
//		Employee e1 = new Employee();
//		e1.setName("Chander");
//		e1.setAddr("11 lincoln street, NE 45904");
//		e1.setDepartment(fin);
//
//		Employee e2 = new Employee();
//		e2.setName("Shekar");
//		e2.setAddr("34 Collins street, CP 23232");
//		e2.setDepartment(fin);
//
//		Employee e3 = new Employee();
//		e3.setName("Raman");
//		e3.setAddr("1231 Oxford street, UK TRE OP4");
//		e3.setDepartment(acc);
//
//		em.persist(fin);
//		em.persist(acc);
//		em.persist(e1);
//		em.persist(e2);
//		em.persist(e3);
//
//		int empId1 = e1.getId();
//		int empId2 = e2.getId();
//		int empId3 = e3.getId();
//		userTran.commit();

		userTran.begin();
		Employee finEmp = em.find(Employee.class, 851);
		Employee accEmp = em.find(Employee.class, 853);
		stdout("Dept of " + finEmp.getName() + " is " + finEmp.getDepartment().getName());
		stdout("Dept of " + accEmp.getName() + " is " + accEmp.getDepartment().getName());

		//get employees in a dept
		Department finDept = em.find(Department.class, 901);
		Collection<Employee> finEmployees = finDept.getEmployees();
		for (Employee financeEmp : finEmployees)
			stdout("Finance Emp " + financeEmp.getName());

		userTran.commit();
	}
}
