package springaop.aroundadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * User: gsunderam
 * Date: May 25, 2013
 *
 * This demonstrates the around advice using spring aop
 *
 * @param call Required to invokke the method
 * @param name arg of the getFoo method
 * @oaram age arg of getFoo method
 */
public class SimpleProfiler {
  public Object profile(ProceedingJoinPoint call, String name, int age) throws Throwable {
      System.out.println("PROFILING Started");
      StopWatch clock = new StopWatch("Profiling for '" + name + "' and '" + age + "'");
      try {
         clock.start(call.toShortString());
         return call.proceed();
      } finally {
         clock.stop();
         System.out.println(clock.prettyPrint());
         System.out.println("PROFILING Ended");
      }
   }
}
