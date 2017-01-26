package jmx;

import springrest.Student;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jul 17, 2015
 */
public class JMXUtils {
	public static void main(String[] args) throws IOException, MalformedObjectNameException {
		JMXServiceURL jmxurl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(jmxurl, null);
		MBeanServerConnection mbsc = connector.getMBeanServerConnection();

		stdout("Domains:");
//		String domains[] = mbsc.getDomains();
//		Arrays.sort(domains);
//
//		for (String domain : domains) {
//    	stdout("\tDomain = " + domain);
//		}

		stdout("\nMBean count = " +  mbsc.getMBeanCount());
		stdout("\nQuery MBeanServer MBeans:");
		QueryExp query =  Query.isInstanceOf(Query.value(Student.class.getName()));

//		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(new ObjectName("Catalina:context=/gsrest,*"), null));
		for (ObjectName name : names) {
    	stdout("\tObjectName = " + name);
		}

		connector.close();
	}
}
