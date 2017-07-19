package yang.yang.springbootdemo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import yang.yang.springbootdemo.other.ConfigProperties;

/**
 * Created by yanyan on 2017/07/05.
 */
@Configuration
@ComponentScan(basePackages = { "yang.yang.springbootdemo.repository","yang.yang.springbootdemo.resource","yang.yang.springbootdemo.entity","yang.yang.springbootdemo.service"})
@EnableConfigurationProperties(ConfigProperties.class)
public class DependencyConfig {

    @Bean
    JerseyConfig getJeseyConfig(){
        return new JerseyConfig();
    }
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
