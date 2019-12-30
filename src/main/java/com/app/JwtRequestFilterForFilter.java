package com.app;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/** this is the jwt response class in pasing the authorization request in Header**/
/** OncePerRequestFilter is an abstract class for filter */
@Component
public class JwtRequestFilterForFilter extends OncePerRequestFilter {

	@Autowired
	private MyuserDetailService myuserDetailService;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization"); /** getting a request through header */
		String username = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		System.out.println(username);

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = myuserDetailService
					.loadUserByUsername(username);/** finding the user details for pericular username */

			if (jwtUtil.validateToken(jwt, userDetails))/** For valid user details and jwt */
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext()
						.setAuthentication(usernamePasswordAuthenticationToken);/** Authenication done **/
			}
		}
		filterChain.doFilter(request, response);

	}

}
