package yang.yang.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by yanyan on 2017/07/25.
 */
//@Aspect
//@Component
public class ExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);

//    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = joinPoint.proceed();
        stopWatch.stop();
        LOGGER.info("this execution cost:{}", stopWatch.toString());
        return proceed;

    }

}