package springinteg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: gsunderam
 * Date: Apr 14, 2013
 */

public class MessageHistDemo {
  public static void main(String[] args) {
    String cfg = "springContext-messagehistory.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
  }
}
