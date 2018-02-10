package com.jurik99.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// --- Configure users (in memory, database, ldap, etc) ---
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		// --- add our users for in memory authentication ---
		User.UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
		    .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		    .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
		    .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
	}

	// --- Configure security of web paths in application, login, logout, etc ---
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests()
		        .anyRequest()
		        .authenticated()
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
			.permitAll();
	}
}
