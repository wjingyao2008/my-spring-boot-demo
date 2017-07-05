package yang.yang.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanyan on 2017/07/05.
 */
@Configuration
public class DependencyConfig {

    @Bean
    public BookController getBookController(){
        return new BookController();
    }

}
