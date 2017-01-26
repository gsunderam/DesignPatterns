package springinteg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: gsunderam
 * Date: Apr 14, 2013
 *
 * This version of the client is awesome! It has no Spring integration dependencies!
 * Code never references any channels or messages. Everything is handled by the Hello Gateway.
 * See resources/springContext.xml. While this code in Spring integ free, this client needs to know the
 * Interface i.e. HelloService in this case
 */
public class HelloWorldExampleV2 {
  public static void main(String[] args) {
    String cfg = "springContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(cfg);

    //Gateway needs to know the interface alone, just as remoting is done in Spring. Gateway impls the interface,
    //constructs the message and sends it to the channel.
    HelloService service = context.getBean("helloGateway", HelloService.class);

    //Using the Gateway interface, just call the business method, just as it is done in RMI. How the message is sent
    //is abstracted out in the Application context.
    service.sayHello("Success");
  }
}
