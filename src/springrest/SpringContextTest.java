package springrest;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * User: gsunderam
 * Date: Oct 16, 2014
 */
public class SpringContextTest {
  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/springJmx.xml");
    System.out.println("Ctx is " + ctx);
  }
}
