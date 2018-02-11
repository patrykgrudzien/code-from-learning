package com.jurik99.config.basic;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

import java.beans.PropertyVetoException;

/*
 *  @EnableWebMvc:
 *  1) Provides similar support to <mvc:annotation-driven /> in XML
 *  2) Adds conversion, formatting and validation support
 *  3) Processing of @Controller classes and @RequestMapping etc... methods
 *
 *  "WebMvcConfigurerAdapter" abstract class has been DEPRECATED cause now in "WebMvcConfigurer" interface we have a lot of
 *  default methods which can be simply OVERRIDDEN :)
 */
@Log4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jurik99")
// It will read the props file (files are automatically copied to classpath during Maven build)
@PropertySource("classpath:persistence-postgresql.properties")
public class SpringServletAndWebXmlConfiguration implements WebMvcConfigurer {

	// --- This object will hold data read from properties file ---
	private final Environment environment;

	@Autowired
	public SpringServletAndWebXmlConfiguration(final Environment environment) {
		this.environment = environment;
	}

	@Bean
	public DataSource securityDataSource() {
		// --- create connection pool (it comes from <artifactId>  c3p0  </artifactId>) ---
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// --- set the jdbc driver ---
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));

			log.info(">>>> jdbc.url=" + environment.getProperty("jdbc.url"));
			log.info(">>>> jdbc.username=" + environment.getProperty("jdbc.user"));

			securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
			securityDataSource.setUser(environment.getProperty("jdbc.username"));
			securityDataSource.setPassword(environment.getProperty("jdbc.password"));

			securityDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
			securityDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
			securityDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
			securityDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
		} catch (PropertyVetoException pve) {
			throw new RuntimeException(pve);
		}
		return securityDataSource;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
