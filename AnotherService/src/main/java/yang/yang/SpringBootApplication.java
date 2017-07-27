package yang.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yanyan on 2017/07/27.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@EnableFeignClients
@EnableEurekaClient
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
