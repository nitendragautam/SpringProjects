package com.nitendratech.bankingapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.nitendratech.bankingapp.model.BankAccount;
import com.nitendratech.bankingapp.service.BankAccountService;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nitendratech.bankingapp.dao.BankAccountDAO;
import com.nitendratech.bankingapp.dao.BankAccountDAOImpl;
import com.nitendratech.bankingapp.service.BankAccountServiceImpl;

/*
 * Configuration Class for Spring beans
 *
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.nitendratech.bankingapp")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
	
	
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");        
        return viewResolver;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");
    }
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
	 
	 @Bean(name = "bankAccountdataSource")
	 public DataSource getDataSource() {
	     BasicDataSource dataSource = new BasicDataSource();
	     dataSource.setDriverClassName("org.sqlite.JDBC");
	     dataSource.setUrl("jdbc:sqlite:/Users/nitendragautam/apps/bankdb.sqlite");
	     dataSource.setMaxActive(100);
	     dataSource.setMinIdle(10);
	     dataSource.setInitialSize(10);
	     dataSource.setMaxIdle(20);
	     dataSource.setValidationQuery("SELECT 1");
	  
	     return dataSource;
	 }
	 
	 //Configure Session Factory bean
	 @Autowired
	 @Bean(name = "bankAccountSessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource) {
	  
	     LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	  
	     sessionBuilder.addAnnotatedClasses(BankAccount.class);
	     sessionBuilder.addProperties(getHibernateProperties());

	     return sessionBuilder.buildSessionFactory();
	 }
	 
	 
	 private Properties getHibernateProperties() {
		    Properties properties = new Properties();
		    properties.put("hibernate.show_sql", "true");
		    properties.put("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
		    properties.put("hibernate.connection.charSet", "UTF-8");
		    properties.put("hibernate.show_sql", "true");
		    properties.put("hibernate.connection.isolation", "2");
		   // properties.put("hibernate.hbm2ddl.auto", "validate");
		    return properties;
		}
	 
	 
	 
	 //Transaction Manager
	 @Autowired
	 @Bean(name = "bankAccountTransactionManager")
	 public HibernateTransactionManager getTransactionManager(
	         SessionFactory sessionFactory) {
	     HibernateTransactionManager transactionManager = 
	    		 new HibernateTransactionManager(
	             sessionFactory);
	  
	     return transactionManager;
	 }
	 
	 
	 //Dao Bean
	 @Autowired
	 @Bean(name = "bankAccountDAO")
	 public BankAccountDAO getBankAccountDAO(SessionFactory sessionFactory) {
	     return new BankAccountDAOImpl(sessionFactory);
	 } 
	 
	 
	//Service Bean
		 @Autowired
		 @Bean(name = "bankAccountService")
		 public BankAccountService getBankAccountService(BankAccountDAO bankAccountDAO) {
		     return new BankAccountServiceImpl(bankAccountDAO);
		 }  
		

}
