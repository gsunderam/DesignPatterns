package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 * User: gsunderam
 * Date: Jan 17, 2015
 */
public class JpaEntityManagerFactory {
	public static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("testjpa");
	}

	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
}
