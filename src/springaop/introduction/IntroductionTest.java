package springaop.introduction;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: May 26, 2013
 *
 * This is using the old style ProxyFactoryBean. AOP Introduction advice is demonstrated here
 */
public class IntroductionTest {
  public static void main(String[] args) {
    BeanFactory ctx = new ClassPathXmlApplicationContext("springAOPIntroduction.xml");
    Car carProxy = (Car) ctx.getBean("car");

    //This is introduction. Now the proxy bean carProxy "is a" PaintColor by virtue of AOP Introduction
    //PaintColor has become the parent of Car
    PaintColor car = (PaintColor) carProxy;

    stdout("carProxy instanceof Car " + (car instanceof Car));
    //This shows the relationship is established. Proxies are very helpful -:)
    stdout("carProxy instanceof PaintColor " + (carProxy instanceof PaintColor));

    /**
     * Get and Set the car color
     * Note that this is done just as though getting and setting is on the Car object, despite the fact that
     * Car has no such methods! That's the purpose of introduction
     */
    stdout("Color of carProxy " + car.getColor());
    car.setColor("blue");
    stdout("Is color of carProxy blue? " + car.getColor());
    car.setColor("green");
    stdout("Is green ? " + car.getColor());
  }
}
