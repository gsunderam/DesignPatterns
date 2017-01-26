package springaop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springaop.ltw.EntitlementCalculationService;

/**
 * User: gsunderam
 * Date: May 26, 2013
 *
 * Load Time Weaving example. Because the weaving is done by aspectJ, beans instantiated via the "new" operator also
 * get weaved with the advice. This works by introspecting the byte codes
 */
public class AspectJAspectsTest {
  public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aspectj.xml");
//     Performance performance = (Performance) ctx.getBean("performance");
//     performance.perform();
  }
}
