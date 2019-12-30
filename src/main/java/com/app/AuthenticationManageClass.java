package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationManageClass {

	@Autowired
	AuthenticationManager authenticationManager;
	/** this is an inbuilt class manages spring bean **/

	@Autowired
	MyuserDetailService myuserDetailService;
	/**
	 * To get valid username from database and matches the given username and
	 * password
	 */

	@Autowired
	JwtUtil JwtUtil;

	/** JWTUtil to generate and validate the JWT token */

	@PostMapping("/auth") /**
							 * it gets username and password in the JSON Formate
							 * {"username":"admin","password":"admin"}
							 */
	public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			/** authenticate is an inbuilt methods exitute through AuthonticationManager */
		} catch (Exception e) {
			throw new Exception("user not found");
		}
		/** generate the token for valid username */
		UserDetails user = myuserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = JwtUtil.generateToken(user);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));/** return token in the header */

	}
}
