package springaop.ltw;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: May 26, 2013
 */
public class EntitlementCalculationService {
  public void calculateEntitlement() {
    stdout("Calculating entitlement");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
