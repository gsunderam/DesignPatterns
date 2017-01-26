package springrest;

import javax.management.Notification;
import javax.management.NotificationListener;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jul 16, 2015
 */
public class SalChangeListener implements NotificationListener {
	@Override
	public void handleNotification(Notification notification, Object handback) {
		stdout("Notification received " + notification);
	}
}
