package yang.yang.companydemo.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.Map;

/**
 * Created by yanyan on 2017/07/19.
 */
//NOTE, when enable jersey,the tomcat are disabled.
public class JerseyConfig extends ResourceConfig implements ApplicationContextAware{


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> pathAnnotation = applicationContext.getBeansWithAnnotation(Path.class);
        pathAnnotation.entrySet().forEach(it -> register(it.getValue()));
    }
}
