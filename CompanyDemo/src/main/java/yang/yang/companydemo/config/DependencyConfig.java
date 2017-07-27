package yang.yang.companydemo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import yang.yang.companydemo.aop.ExampleAspect;
import yang.yang.companydemo.other.ConfigProperties;

/**
 * Created by yanyan on 2017/07/05.
 */
@Configuration
@ComponentScan(basePackages = { "yang.yang.companydemo.repository","yang.yang.companydemo.resource","yang.yang.companydemo.entity","yang.yang.companydemo.service"})
@EnableConfigurationProperties(ConfigProperties.class)
public class DependencyConfig {

    @Bean
    ExampleAspect aspect(){
        return new ExampleAspect();
    }
//    @Bean
//    JerseyConfig getJeseyConfig(){
//        return new JerseyConfig();
//    }
//    @Bean
//    @Autowired
//    @Primary
//    public PlatformTransactionManager transactionManager(EntityManagerFactory ptvEntityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(ptvEntityManagerFactory);
//        return txManager;
//    }
//
//    @Bean(name = "entityManagerFactory")
//    @Autowired
//    @Primary
//    public LocalContainerEntityManagerFactoryBean ptvEntityManagerFactory(DataSource statsDataSource) {
//
//        return createEntityManager(statsDataSource,
//                                   "yang.yang.springbootdemo.entity"
//        );
//    }
//
//    protected LocalContainerEntityManagerFactoryBean createEntityManager(DataSource dataSource,
//                                                                         String... packagesToScan) {
//        // hibernate adapter
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//        vendorAdapter.setDatabase(Database.MYSQL);
//
//        Map<String, String> props = new HashMap<>();
//        props.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
//        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
//        //props.put("hibernate.cache.use_query_cache", "true");
//
//        // entity manager factory bean
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//
//        factory.setPersistenceUnitName("yangyang");
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(packagesToScan);
//        factory.setDataSource(dataSource);
//        factory.setJpaPropertyMap(props);
//
//        return factory;
//    }


}
