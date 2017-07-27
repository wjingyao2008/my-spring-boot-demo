package yang.yang.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by yanyan on 2017/07/27.
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterDiscoveryService {
    public static void main(String[] args) {
        SpringApplication.run(RegisterDiscoveryService.class, args);
    }
}
