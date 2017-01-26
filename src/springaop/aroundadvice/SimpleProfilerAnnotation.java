package springaop.aroundadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * User: gsunderam
 * Date: May 25, 2013
 * This demonstrates the around advice using spring aspectj annotations
 */
@Aspect
public class SimpleProfilerAnnotation {

  /**
   * This tells the Aspectj that getFoo method that has name and age args has to be intercepted
   * The method is just a marker indicating that it refers to the pointcut.
   */
  @Pointcut("execution(* springaop.aroundadvice.FooService.getFoo(String,int)) && args(name, age)")
  public void profileMarker(String name, int age) {}

  /**
   * 
   * @param call jpinpoint used to call proceed
   * @param name name arg that was passed to getFoo
   * @param age Arg of getFoo
   * @return
   * @throws Throwable
   */
  @Around("profileMarker(name, age)")
  public Object profile(ProceedingJoinPoint call, String name, int age) throws Throwable {
      System.out.println("PROFILING Started");
      StopWatch clock = new StopWatch("Profiling for '" + name + "' and '" + age + "'");
      try {
         clock.start(call.toShortString());
         System.out.println("This is nice, Task name is = " + call.toShortString());
         return call.proceed();
      } finally {
         clock.stop();
         System.out.println(clock.prettyPrint());
         System.out.println("PROFILING Ended");
      }
   }
}
