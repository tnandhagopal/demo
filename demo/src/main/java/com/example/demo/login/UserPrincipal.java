package com.example.demo.login;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.employee.Employee;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Employee user;

	public UserPrincipal(Employee user) {
		super();
		this.user = user;
	}

	public Employee getUser() {
		return this.user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		// return Collections.singleton(new SimpleGrantedAuthority("USER"));

		return this.user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}
