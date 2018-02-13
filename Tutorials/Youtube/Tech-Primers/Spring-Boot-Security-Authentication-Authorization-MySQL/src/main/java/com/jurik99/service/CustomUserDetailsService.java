package com.jurik99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.jurik99.model.CustomUserDetails;
import com.jurik99.model.Users;
import com.jurik99.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UsersRepository usersRepository;

	@Autowired
	public CustomUserDetailsService(final UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final Optional<Users> userOptional = usersRepository.findByName(username);

		return userOptional.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
