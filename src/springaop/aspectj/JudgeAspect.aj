package springaop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: May 27, 2013
 */
public aspect JudgeAspect {
  private CriticismEngine criticismEngine;
  
  public JudgeAspect() {}

  pointcut performance() : execution(* springaop.aspectj.Performance.perform(..))

  after() returning : performance() {
      stdout(criticismEngine.getCriticism());
  }
}
