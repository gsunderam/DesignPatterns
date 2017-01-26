package springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Sep 25, 2013
 */
public class SpringListener {
  public static void main(String[] args) {
    new ClassPathXmlApplicationContext("spring-jms-listener.xml");
    stdout("Spring POJO Message bean activated");
  }
}
