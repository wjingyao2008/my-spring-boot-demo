package yang.yang.companydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import yang.yang.companydemo.config.DependencyConfig;

//this is same as same as @Configuration @EnableAutoConfiguration @ComponentScan
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@Import(DependencyConfig.class)
@ConfigurationProperties
@EnableAspectJAutoProxy
@EnableEurekaClient
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
