package com.jurik99.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jurik99.repository.UsersRepository;
import com.jurik99.service.CustomUserDetailsService;

@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	public SecurityConfiguration(final CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		// --- service is gonna connect to database and get the data  ---
		auth.userDetailsService(customUserDetailsService)
		    .passwordEncoder(getPasswordEncoder());
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(final CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(final CharSequence charSequence, final String s) {
				return true;
			}
		};
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests()
		    .antMatchers("**/secure/**").authenticated()
	        .anyRequest().permitAll()
	        .and()
	        .formLogin().permitAll();
	}
}
