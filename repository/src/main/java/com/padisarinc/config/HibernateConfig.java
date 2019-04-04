package com.padisarinc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.hibernate.cfg.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
/**
 * @Configuration is child of @Component and because we want spring framework
 * will make this object, hence we put @Configuration over head it
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    /**
     * Why we use @Bean annotation here?
     * When in other place we want to inject (@Autowierd) DataSource, we need a DataSource, hence
     * here we put @Bean over head of this method that return DataSource
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/javad");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Me#rAzar123698745");
        return driverManagerDataSource;
    }


    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(ds);
        return txManager;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.padisarinc.entities"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
        hibernateProperties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }
}