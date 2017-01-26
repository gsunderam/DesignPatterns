package springinteg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * User: gsunderam
 * Date: Apr 14, 2013
 *
 * This version of the client has spring integration dependencies. Message Channel, MBuilder etc.
 */
public class HelloWorldExample {
  public static void main(String[] args) {
    String cfg = "springContext.xml";
    //Similar to Initial Context
    ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
    
    //Get the channel. III'r to getting queue from JNDI. q = context.lookup("Queue")
    MessageChannel channel = context.getBean("names", MessageChannel.class);

    //construct msg. Similar to session.createTextMsg...
    Message<String> message = MessageBuilder.withPayload("Tamil New Year").build();
    
    //Send. Similar to sender.send(msg)
    channel.send(message);
  }
}
