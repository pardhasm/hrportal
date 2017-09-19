package com.hrportal.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.hrportal.constants.APIConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

@Configuration
@EnableJpaRepositories(basePackages = "com.hrportal.repository")
@EnableTransactionManagement

public class CommonConfig {

    @Value("${spring.jpa.show-sql:false}")
    private boolean showSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule()).setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        mapper.setTimeZone(TimeZone.getTimeZone(APIConstants.TIME_ZONE_ID));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(showSql);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "jpaProperties")
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", ddl);
        props.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        return props;
    }

    @Bean
    public RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(buildMapper());
        messageConverters.add(jsonMessageConverter);
        messageConverters.add(new StringHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
