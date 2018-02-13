package com.jurik99.config.security;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Log4j
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	private DataSource securityDataSource;

	@Autowired
	public DemoSecurityConfig(final DataSource securityDataSource) {
		this.securityDataSource = securityDataSource;
	}

	// --- Configure users (database this time) ---
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		log.info(">>>> JDBC Authentication");

		auth.jdbcAuthentication()
		    .dataSource(securityDataSource)
		    .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
			.authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username=?");
	}

	// --- Configure security of web paths in application, login, logout, etc ---
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		log.info(">>>> HTTPSecurity configure");

		http.authorizeRequests()
//		        .anyRequest()
//		        .authenticated()
                // --- new we don't need authenticated ---
		        .antMatchers("/").hasRole("USER")
		        .antMatchers("/leaders/**").hasRole("ADMIN")
		        .antMatchers("/systems/**").hasRole("ADMIN")
		    .and()
		    .formLogin()
		        .loginPage("/showMyLoginPage")
		        // login form should POST data to this URL for processing (check user id and password)
		        .loginProcessingUrl("/authenticateTheUser")
		        // allow everyone to see login page. No need to be logged in
		        .permitAll()
		    .and()
			    /*
			     * Logout process:
			     * When a logout is processed, by default Spring Security will:
			     * 1) Invalidate user's HTTP session and remove session cookies, etc
			     * 2) Send user back to your login page
			     * 3) Append a logout parameter: ?logout
			     */
			    .logout()
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	// --- Without it, I'm getting EXCEPTION -> There is no PasswordEncoder mapped for the id “null” ---
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
