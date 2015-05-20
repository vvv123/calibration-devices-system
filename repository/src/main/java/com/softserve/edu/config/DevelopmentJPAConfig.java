package com.softserve.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.softserve.edu.repository")
@PropertySource(value = "/WEB-INF/database.properties")
@Profile("dev")
public class DevelopmentJPAConfig {
    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DriverManagerDataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(env.getProperty("em.packagesToScan"));
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory,
                                                         DriverManagerDataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    private Map<String, String> jpaProperties() {
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", env.getProperty("hb.dialect"));
        jpaProperties.put("hibernate.connection.useUnicode", env.getProperty("hb.conn.useUnicode"));
        jpaProperties.put("hibernate.connection.characterEncoding", env.getProperty("hb.conn.characterEncoding"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("hb.showSql"));
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hb.hbm2ddl.auto"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("hb.formatSql"));
        jpaProperties.put("hibernate.use_sql_comments", env.getProperty("hb.sqlComment"));
        jpaProperties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("hb.enableLazyLoadNoTrans"));
        return jpaProperties;
    }
}
