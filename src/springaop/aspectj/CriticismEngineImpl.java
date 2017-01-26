package springaop.aspectj;

/**
 * User: gsunderam
 * Date: May 27, 2013
 */
public class CriticismEngineImpl implements CriticismEngine {
  private String[] pool;

  public CriticismEngineImpl() {}

  public String getCriticism() {
    int i = (int) (Math.random() * pool.length);
    return pool[i];
  }

  public void setPool(String[] pool) {
    this.pool = pool;
  }
}
