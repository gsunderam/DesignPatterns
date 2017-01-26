package springjms;

import org.springframework.stereotype.Component;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Sep 25, 2013
 */
@Component
public class SpringMsgBean {
  public void onMessage(String msg) {
    stdout("Spring message received: " + msg);
  }
}
