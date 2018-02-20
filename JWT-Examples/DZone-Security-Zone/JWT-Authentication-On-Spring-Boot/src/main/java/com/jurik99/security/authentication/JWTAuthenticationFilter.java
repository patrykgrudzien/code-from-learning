package com.jurik99.security.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.jurik99.constants.SecurityConstants;
import com.jurik99.domain.ApplicationUser;

/**
 * Implement an authentication filter to issue JWTs to users sending credentials.
 *
 * Note that the authentication filter that we created extends the "UsernamePasswordAuthenticationFilter" class. When we add a
 * new filter to Spring Security, we can explicitly define where is the "filter chain" we want that filter, or we can let the
 * framework figure it out by itself. By extending the filter provided within the security framework, Spring can automatically
 * identify the best place to put it in the security chain.
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(final AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * We parse the user's credentials and issue them to the "AuthenticationManager"
	 */
	@Override
	public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws AuthenticationException {

		try {
			// --- take credentials ---
			final ApplicationUser credentials = new ObjectMapper().readValue(request.getInputStream(), ApplicationUser.class);

			// --- authentication and Token generation ---
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getUsername(),
					                                        credentials.getPassword(),
					                                        new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method is called when user successfully logs in. We use this method to generate a JWT for this user.
	 */
	@Override
	protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
	                                        final FilterChain chain, final Authentication authentication)
			throws IOException, ServletException {

		final String token = Jwts.builder()
		                         // cast to User class (comes from org.springframework.security.core.userdetails.User)
		                         .setSubject(((User) authentication.getPrincipal()).getUsername())
		                         .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
		                         .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
		                         .compact();

		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	}
}
