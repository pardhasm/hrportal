package com.hrportal.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "maindbFactory", transactionManagerRef = "mainDntrmanager", basePackages = {"com.hrportal"})
public class Maindbconfig {
    private String opsModelPackages = "com.hrportal.model";


    @Bean(name = "mainDntrmanager")
    public PlatformTransactionManager mainTransactionManager(@Qualifier("maindbFactory") LocalContainerEntityManagerFactoryBean deliveryEntityManagerFactory) {
        return new JpaTransactionManager(deliveryEntityManagerFactory.getObject());
    }


    @Bean(name = "mainjpaProperties")
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        props.setProperty("hibernate.jdbc.time_zone", "GMT");
        props.setProperty("hibernate.jdbc.show-sql", "true");

        return props;
    }


    @Bean(name = "maindbFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter, @Qualifier("mainjpaProperties") Properties jpaProperties, @Qualifier("mainDbdatasourse") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPersistenceUnitName("maindb");
        factoryBean.setPackagesToScan(opsModelPackages.split(","));
        return factoryBean;
    }

    @Bean(name = "mainDbdatasourse")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDbdatasourse() {
        return DataSourceBuilder.create().build();
    }
}
