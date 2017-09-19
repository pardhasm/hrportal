package com.hrportal.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatasourceConfig {


    @Value("${mainModelPackages}")
    private String mainModelPackages;

    @Bean
    @Primary
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter, @Qualifier("jpaProperties") Properties jpaProperties, @Qualifier("mainDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(mainModelPackages.split(","));
        return factoryBean;
    }

    @Bean(name = "mainDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

}
