package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by admin on 22.11.2018.
 */
@Configuration
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
    @Autowired
    private Environment env;

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DataSource setSecurityDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
//        myLogger.info("=======>"+env.getProperty("jdbc.url"));
//        myLogger.info("=======>"+env.getProperty("jdbc.user"));
//        myLogger.info("=======>"+env.getProperty("jdbc.password"));

        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(getIntFromProperty("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(getIntFromProperty("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(getIntFromProperty("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(getIntFromProperty("connection.pool.maxIdleTime"));
        return dataSource;
    }

    public int getIntFromProperty(String s){
        String propVal = env.getProperty(s);
        return Integer.parseInt(propVal);
    }

    private Properties getHibernateProperties() {

        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        // create session factorys
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource(setSecurityDataSource());
//        myLogger.info("=======>"+env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

}
