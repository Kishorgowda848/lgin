package com.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyuserDetailService implements UserDetailsService
/**
 * UserDetailsService is an inbuilt spring security 
 */
{
	/** to override the user details of UserDetailsService class inbuilt methods */
	@Autowired
	private UserRepository userRepository;

	/** geting user table from user repository table */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = userRepository.findByUserName(username); /** finding username */

		user.orElseThrow(() -> new UsernameNotFoundException("user name not found"));
		/** if user name doesn't exesist than throgh error */

		return user.map(MyUserDetails::new).get();/** passing value to the MyuserDetails constructor */
	}

}
