package com.d3.infra.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.d3.common.model.items.Image;
import com.d3.common.model.items.UnidentifiedItem;
import com.d3.common.model.player.Player;
import com.d3.common.model.player.UnidBunch;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * In-memory Hibernate + HSQL config for testing
 * @author mbmartinez
 */

@Configuration
@PropertySource("classpath:test.properties")
@EnableJpaRepositories(basePackages="com.d3.infra.repo")
@EnableTransactionManagement
public class TestConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("jpa.driverClass"));
		dataSource.setJdbcUrl(env.getProperty("jpa.url"));
		dataSource.setUser(env.getProperty("jpa.username"));
		dataSource.setPassword(env.getProperty("jpa.password"));

		//c3p0-specific properties follow
		dataSource.setAcquireIncrement(1);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(5);
		dataSource.setMaxIdleTime(600);

		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));       
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		return properties;

	}

	@Bean
	public EntityManagerFactory entityManagerFactory() throws Exception {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(new String[] { "com.d3.common.model" });
		entityManagerFactory.setPersistenceProvider(new HibernatePersistence());
		entityManagerFactory.setJpaProperties(hibernateProperties());
		entityManagerFactory.afterPropertiesSet();
		return entityManagerFactory.getObject();

	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
		transactionManager.setDataSource(dataSource());
		transactionManager.setJpaDialect(new HibernateJpaDialect());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	/**
	 * Hibernate-specific interface. {@link#entityManagerFactory} is part of JPA spec and should be preferred, 
	 * but this (and the accompanying Hibernate Restrictions classes are too convenient not to use)
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public SessionFactory sessionFactory() throws Exception {
		return new LocalSessionFactoryBuilder(dataSource())
		.addAnnotatedClass(Player.class)
		.addAnnotatedClass(Image.class)
		.addAnnotatedClass(UnidentifiedItem.class)
		.addAnnotatedClass(UnidBunch.class)
		.buildSessionFactory();
	}
}
