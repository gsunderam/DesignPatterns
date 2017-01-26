package springaop.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: gsunderam
 * Date: May 26, 2013
 *
 * Load Time Weaving example. Because the weaving is done by aspectJ, beans instantiated via the "new" operator also
 * get weaved with the advice. This works by introspecting the byte codes
 */
public class LTWTest {
  public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("springAspectJ.xml");
     EntitlementCalculationService entitlementCalculationService =
             //(EntitlementCalculationService) ctx.getBean("entitlementCalculationService");
             new EntitlementCalculationService();

     // the profiling aspect is 'woven' around this method execution
    entitlementCalculationService.calculateEntitlement();
  }
}
