package yang.yang.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyan on 2017/07/05.
 */
@Configuration
@ComponentScan(basePackages = { "yang.yang.springbootdemo"})
public class DependencyConfig {

    @Bean
    @Autowired
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory ptvEntityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(ptvEntityManagerFactory);
        return txManager;
    }

    @Bean(name = "entityManagerFactory")
    @Autowired
    @Primary
    public LocalContainerEntityManagerFactoryBean ptvEntityManagerFactory(DataSource statsDataSource) {

        return createEntityManager(statsDataSource,
                                   "yang.yang.springbootdemo.entity"
        );
    }

    protected LocalContainerEntityManagerFactoryBean createEntityManager(DataSource dataSource,
                                                                         String... packagesToScan) {
        // hibernate adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setDatabase(Database.MYSQL);

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        //props.put("hibernate.cache.use_query_cache", "true");

        // entity manager factory bean
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setPersistenceUnitName("yangyang");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(packagesToScan);
        factory.setDataSource(dataSource);
        factory.setJpaPropertyMap(props);

        return factory;
    }


}
