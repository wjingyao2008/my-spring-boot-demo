package yang.yang.companydemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanyan on 2017/07/25.
 */
@Aspect
//@Component
public class ExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);

    //Around is one advice,others are Before and else
    //also we can use 	@Pointcut("within(com.journaldev.spring.service.*)") to add complex rule
    @Around("@annotation(yang.yang.companydemo.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("start execution:[{}]", joinPoint.getSignature().toShortString());
        long currentTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long elapsedTime = System.currentTimeMillis() - currentTime;
            LOGGER.info("execution [{}] cost:{} millis", joinPoint.getSignature().toShortString(), elapsedTime);
        }
    }

}