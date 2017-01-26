package springinteg;

/**
 * User: gsunderam
 * Date: Apr 14, 2013
 */
public class MyHelloService implements HelloService {
  public void sayHello(String message) {
   System.out.println("Hello " + message);
  }
}
