package springjms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import springaop.ltw.EntitlementCalculationService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Sep 22, 2013
 */
public class SpringActiveMQ {
    public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-amq.xml");
       JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");

       jmsTemplate.send(new MessageCreator(){

         public Message createMessage(Session session) throws JMSException {
           return session.createTextMessage("Success with MDP");
         }
       });
    }
}
