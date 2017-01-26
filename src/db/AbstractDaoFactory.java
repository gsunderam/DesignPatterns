package db;

import javax.persistence.EntityManagerFactory;

/**
 * User: gsunderam
 * Date: Jan 10, 2015
 */
public abstract class AbstractDaoFactory {
  public abstract EntityManagerFactory getEntityManagerFactory(String dbType);
}
