package springaop.ltw;

/**
 * User: gsunderam
 * Date: May 26, 2013
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * These are called as @AspectJ annotations. Spring has nothing to do with these. All the weaving and advising
 * is done by the aspectj runtime
 */
@Aspect
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }

    @Pointcut("execution(public * springaop.ltw..*.*(..))")
    public void methodsToBeProfiled(){}
}
