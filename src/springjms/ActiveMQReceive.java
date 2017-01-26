package springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Sep 22, 2013
 */
public class ActiveMQReceive {
  public static void main(String[] args) throws JMSException {
    while(true) {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-amq.xml");
      JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");

      TextMessage message = (TextMessage) jmsTemplate.receive();
      stdout("Message received is " + message.getText());
      if (message.getText().equalsIgnoreCase("quit")) break;
    }

    stdout("Good Bye from ActiveMQ");
  }
}
