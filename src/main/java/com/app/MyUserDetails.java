package com.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** to override UserDetails methods */
public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private Boolean active;
	private List<GrantedAuthority> authority;

	/** the User class used to get all details from user table */
	public MyUserDetails(Users user) /* this constructor is used to overrride userDetailService */
	{
		this.userName = user.getUserName();
		this.password = user.getPass();
		this.active = user.getActive();
		this.authority = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}
