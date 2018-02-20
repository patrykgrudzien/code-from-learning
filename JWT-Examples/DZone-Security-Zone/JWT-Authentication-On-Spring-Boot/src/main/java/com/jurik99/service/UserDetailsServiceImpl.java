package com.jurik99.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import com.jurik99.domain.ApplicationUser;
import com.jurik99.repository.ApplicationUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(final ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
	}
}
