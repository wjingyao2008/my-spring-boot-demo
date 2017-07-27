# my-spring-boot-demo
my-spring-boot-demo
1. https://start.spring.io/ to generate pom
2. https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
3. https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/transaction.html
# to correct use git
got trouble by push with another user.
now it use:
1. git remote set-url origin https://wjingyao2008@github.com/wjingyao2008/my-spring-boot-demo.git

# Tips
## Auto Generated Values
```$xslt
@GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
```
Identity - After an insert ask the auto incerement column for the value of the item
Sequence - the value comes from a db sequence
table - the value comes from another table in the database
auto - pick one of the above based on the database type
UUID - generate a UUID before doing an insert

## How Find parameter
1. add maven pom <artifactId>spring-boot-starter-actuator</artifactId>
2. add @ConfigurationProperties
3. visit /configprops 
4. for test only. set management.security.enabled=false

##  @ResponseBody and @RestController
1. RestController is combine of @ResponseBody and @Controller
2. ResponseBody make you direct return value without View.

## profile
profile can be actived in group by "prod",activate prod will also activate prodd,prodmq
spring.profiles: prod
spring.profiles.include:
  - proddb
  - prodmq
## color log spring.output.ansi.enabled

## jeseyConfig enable the JRX
but this will disable TOMCAT
## spring can simple the kafka
## 


# MicroService
## 1. Build
mvn clean package
java -jar spring-boot-demo-0.0.1-SNAPSHOT.jar
## 2. Registration and Discovery service (Eureka service)
```$xslt
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-eureka-server</artifactId>
    </dependency>
```
 https://github.com/Netflix/eureka/wiki/Configuring-Eureka