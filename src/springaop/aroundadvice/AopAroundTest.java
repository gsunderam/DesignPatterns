package springaop.aroundadvice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: gsunderam
 * Date: May 25, 2013
 */
public class AopAroundTest {
  public static void main(final String[] args) throws Exception {
      //BeanFactory ctx = new ClassPathXmlApplicationContext("springAOP.xml");
      BeanFactory ctx = new ClassPathXmlApplicationContext("springAOPAnnotation.xml");
      FooService foo = (FooService) ctx.getBean("fooService");
      foo.getFoo("Pengo", 12);
   }
}
