package yang.yang.companydemo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by yanyan on 2017/07/25.
 */
@Target(ElementType.METHOD)
//@Retention just states whether the annotation will be available to the JVM at runtime or not.
// By default it is not, so Spring AOP would not be able to see the annotation. This is why it’s been reconfigured.
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {

}
