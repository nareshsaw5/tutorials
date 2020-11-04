package audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecuredMethodAspect {



    @Before("hello()")
    public void logMethodAcceptionEntityAnnotatedBean(JoinPoint jp) {
        System.out.println("Accepting beans with @Entity annotation: ");
    }


    @Pointcut("execution(* audit.SecuredMethod.*(..))")
    public void hello() {
    }
}