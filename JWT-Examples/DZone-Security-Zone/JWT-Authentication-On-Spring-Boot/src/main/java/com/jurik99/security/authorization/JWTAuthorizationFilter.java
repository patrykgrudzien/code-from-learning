package com.jurik99.security.authorization;

import io.jsonwebtoken.Jwts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import com.jurik99.constants.SecurityConstants;

/**
 * We have extended the "BasicAuthenticationFilter" to make Spring replace it in the "filter chain" with our custom
 * implementation. The most important part of the filter that we've implemented is the private "getAuthenticationToken()"
 * method. This method reads the JWT from the "Authorization" header, and then uses "JWTs" to validate the token. If everything
 * is in place, we set the user in the "SecurityContext" and allow the request to move on.
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(final AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader(SecurityConstants.HEADER_STRING);

		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		final UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthenticationToken(final HttpServletRequest request) {

		String header = request.getHeader(SecurityConstants.HEADER_STRING);

		if (header != null) {
			// parse the token
			final String user = Jwts.parser()
			                        .setSigningKey(SecurityConstants.SECRET)
			                        .parseClaimsJws(header.replace(SecurityConstants.TOKEN_PREFIX, ""))
			                        .getBody()
			                        .getSubject();
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			return null;
		}
		return null;
	}
}
